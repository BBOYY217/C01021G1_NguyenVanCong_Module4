package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/blogs")
    public ModelAndView listBlogs(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView saveCreate(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "New Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Update Blog successfully");
        return modelAndView;
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showDelete(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        if (blog.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/blog/delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteBlog(@ModelAttribute("Blog") Blog blog) {
//        blogService.remove(blog.getId());
//        return "redirect:blogs";
//    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Long id, RedirectAttributes redirectAttributes ){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("massage","delete successfully");
        return  "redirect:/blogs";
    }

}
