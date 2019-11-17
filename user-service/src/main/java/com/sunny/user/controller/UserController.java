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

    @PostMapping("/userentity")
    public UserEntity save(@RequestBody UserEntity userentity){
        return userentityService.save(userentity);
    }

    @GetMapping("/userentity/{id}")
    public UserEntity getById(@PathVariable(value = "id") String id){
        return userentityService.find(id);
    }

    @GetMapping("/userentity")
    public List<UserEntity> getAll(){
        return userentityService.findAll();
    }

    @DeleteMapping("/userentity/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        userentityService.delete(id);
    }

    @DeleteMapping("/userentity")
    public void deleteAll(){
        userentityService.deleteAll();
    }

    @GetMapping("/userentity/count")
    public long count(){
        return userentityService.count();
    }
}