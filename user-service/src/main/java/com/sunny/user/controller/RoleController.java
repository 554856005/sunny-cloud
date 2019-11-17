package com.sunny.user.controller;

import com.sunny.user.entity.RoleEntity;
import com.sunny.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class RoleController {

    @Autowired
    private RoleService roleentityService;

    @PostMapping("/roleentity")
    public RoleEntity save(@RequestBody RoleEntity roleentity){
        return roleentityService.save(roleentity);
    }

    @GetMapping("/roleentity/{id}")
    public RoleEntity getById(@PathVariable(value = "id") String id){
        return roleentityService.find(id);
    }

    @GetMapping("/roleentity")
    public List<RoleEntity> getAll(){
        return roleentityService.findAll();
    }

    @DeleteMapping("/roleentity/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        roleentityService.delete(id);
    }

    @DeleteMapping("/roleentity")
    public void deleteAll(){
        roleentityService.deleteAll();
    }

    @GetMapping("/roleentity/count")
    public long count(){
        return roleentityService.count();
    }
}