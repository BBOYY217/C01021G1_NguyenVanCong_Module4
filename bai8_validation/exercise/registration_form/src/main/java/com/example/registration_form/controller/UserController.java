package com.example.registration_form.controller;

import com.example.registration_form.dto.UserDto;
import com.example.registration_form.model.User;
import com.example.registration_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ModelAndView listUser(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                 @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 3);
        Page<User> users = this.userService.findAllByKeyWord(keyword, pageable);
        ModelAndView modelAndView = new ModelAndView("/user/list", "users", users);
        modelAndView.addObject("keyword", keyword);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/user/create",
                "userDto", new UserDto());
        return modelAndView;
    }
    
    @PostMapping("/create")
    public String saveCreate(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setFlag(true);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam Long id, Model model) {
        User user = this.userService.findById(id).orElse(null);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        model.addAttribute("userDto", userDto);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setFlag(true);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "edit successfully");
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        userService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/user";
    }

}
