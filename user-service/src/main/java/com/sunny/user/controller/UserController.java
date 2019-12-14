package com.sunny.user.controller;

import com.sunny.common.dto.user.UserDTO;
import com.sunny.common.utils.Result;
import com.sunny.user.entity.UserEntity;
import com.sunny.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserInfo")
    public UserDTO findUserInfo(@RequestParam String loginName) {
        return userService.findUserInfo(loginName);
    }

    @PostMapping("/save")
    public Result<UserEntity> save(@RequestBody UserEntity userentity) {
        return Result.ofSuccess(userService.save(userentity));
    }

    @GetMapping("/getById/{id}")
    public Result<UserEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(userService.find(id));
    }

    @GetMapping("/getAll")
    public Result<List<UserEntity>> getAll() {
        return Result.ofSuccess(userService.findAll());
    }


    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        userService.delete(id);
        return Result.ofSuccess();
    }


    @GetMapping("/count")
    public Result<Long> count() {
        return Result.ofSuccess(userService.count());
    }
}