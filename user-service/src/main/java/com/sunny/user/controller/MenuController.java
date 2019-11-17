package com.sunny.user.controller;

import com.sunny.user.entity.MenuEntity;
import com.sunny.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class MenuController {

    @Autowired
    private MenuService menuentityService;

    @PostMapping("/menuentity")
    public MenuEntity save(@RequestBody MenuEntity menuentity){
        return menuentityService.save(menuentity);
    }

    @GetMapping("/menuentity/{id}")
    public MenuEntity getById(@PathVariable(value = "id") String id){
        return menuentityService.find(id);
    }

    @GetMapping("/menuentity")
    public List<MenuEntity> getAll(){
        return menuentityService.findAll();
    }

    @DeleteMapping("/menuentity/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        menuentityService.delete(id);
    }

    @DeleteMapping("/menuentity")
    public void deleteAll(){
        menuentityService.deleteAll();
    }

    @GetMapping("/menuentity/count")
    public long count(){
        return menuentityService.count();
    }
}