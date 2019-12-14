package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.UserEntity;
import com.sunny.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Result<UserEntity> save(@RequestBody UserEntity userentity) {
        return Result.ofSuccess(userService.save(userentity));
    }

    @GetMapping("/user/{id}")
    public Result<UserEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(userService.find(id));
    }

    @GetMapping("/user")
    public Result<List<UserEntity>> getAll() {
        return Result.ofSuccess(userService.findAll());
    }


    @DeleteMapping("/user/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        userService.delete(id);
        return Result.ofSuccess();
    }

    @DeleteMapping("/user")
    public Result deleteAll() {
        userService.deleteAll();
        return Result.ofSuccess();
    }

    @GetMapping("/user/count")
    public Result<Long> count() {
        return Result.ofSuccess(userService.count());
    }
}