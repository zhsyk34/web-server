package com.dnk.controller;

import com.dnk.entity.Lock;
import com.dnk.service.LockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/lock")
public class LockController {

    @Resource
    private LockService lockService;

    @GetMapping("index")
    public String index() {
        return "goodbye";
    }

    @GetMapping("{id}")
    public Lock index(@PathVariable int id) {
        return lockService.find(id);
    }

}
