package com.sunny.user.controller;

import com.sunny.user.entity.UserEntity;
import com.sunny.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userentityService;

    @PostMapping("/user")
    public UserEntity save(@RequestBody UserEntity userentity){
        return userentityService.save(userentity);
    }

    @GetMapping("/user/{id}")
    public UserEntity getById(@PathVariable(value = "id") String id){
        return userentityService.find(id);
    }

    @GetMapping("/user")
    public List<UserEntity> getAll(){
        return userentityService.findAll();
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        userentityService.delete(id);
    }

    @DeleteMapping("/user")
    public void deleteAll(){
        userentityService.deleteAll();
    }

    @GetMapping("/user/count")
    public long count(){
        return userentityService.count();
    }
}