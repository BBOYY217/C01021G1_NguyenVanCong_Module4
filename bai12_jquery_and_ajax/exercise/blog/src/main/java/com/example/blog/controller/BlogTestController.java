package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/blogs")
public class BlogTestController {

    @Autowired
    private IBlogService blogService;


    @GetMapping
    public ResponseEntity<Page<Blog>> allBlog(@RequestParam("page") Optional<Integer> page,
                                              @RequestParam("search") Optional<String> search) {
        Pageable pageable= PageRequest.of(0,1+page.orElse(0));
        Page<Blog> blogs = this.blogService.findAllByTitleContaining(search.orElse(""),pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping(value = "/{search}")
    public ResponseEntity<List<Blog>> allBlogBySearch(@PathVariable Optional<String> search) {
        List<Blog> blogs = this.blogService.findAllByTitleContaining(search.orElse(""));
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
