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

    @PostMapping("/role")
    public RoleEntity save(@RequestBody RoleEntity roleentity){
        return roleentityService.save(roleentity);
    }

    @GetMapping("/role/{id}")
    public RoleEntity getById(@PathVariable(value = "id") String id){
        return roleentityService.find(id);
    }

    @GetMapping("/role")
    public List<RoleEntity> getAll(){
        return roleentityService.findAll();
    }

    @DeleteMapping("/role/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        roleentityService.delete(id);
    }

    @DeleteMapping("/role")
    public void deleteAll(){
        roleentityService.deleteAll();
    }

    @GetMapping("/role/count")
    public long count(){
        return roleentityService.count();
    }
}