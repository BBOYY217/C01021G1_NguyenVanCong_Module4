package com.example.case_study.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("")
    public String showIndex() {
        return "controller/home";
    }
}
