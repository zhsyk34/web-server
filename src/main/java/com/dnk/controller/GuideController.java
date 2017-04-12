package com.dnk.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuideController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping("/index")
    public String index() {
        System.out.println("index-------------->>>>>>>>>>>>>>>>>");
        return "index";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    public String error() {
        return "error";
    }

}
