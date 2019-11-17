package com.sunny.user.controller;

import com.sunny.user.entity.PermissionEntity;
import com.sunny.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class PermissionController {

    @Autowired
    private PermissionService permissionentityService;

    @PostMapping("/permission")
    public PermissionEntity save(@RequestBody PermissionEntity permissionentity){
        return permissionentityService.save(permissionentity);
    }

    @GetMapping("/permission/{id}")
    public PermissionEntity getById(@PathVariable(value = "id") String id){
        return permissionentityService.find(id);
    }

    @GetMapping("/permission")
    public List<PermissionEntity> getAll(){
        return permissionentityService.findAll();
    }

    @DeleteMapping("/permission/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        permissionentityService.delete(id);
    }

    @DeleteMapping("/permission")
    public void deleteAll(){
        permissionentityService.deleteAll();
    }

    @GetMapping("/permission/count")
    public long count(){
        return permissionentityService.count();
    }
}