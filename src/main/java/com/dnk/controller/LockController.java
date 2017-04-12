package com.dnk.controller;

import com.dnk.entity.Lock;
import com.dnk.service.LockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/lock")
public class LockController {

    @Resource
    private LockService lockService;

    @GetMapping("{id}")
    public Result<Lock> get(@PathVariable long id) {
        return Result.success(lockService.getById(id));
    }

    @DeleteMapping("{id}")
    public Result<String> delete(@PathVariable long id) {
        System.out.println(id);
        return Result.success(Long.toString(id));
    }

}
