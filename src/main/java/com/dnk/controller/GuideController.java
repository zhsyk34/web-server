package com.dnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuideController {

    @GetMapping("/")
    public String index() {
        System.out.println("index-------------->>>>>>>>>>>>>>>>>");
        return "index";
    }
}
