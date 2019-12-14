package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.PermissionEntity;
import com.sunny.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/permission")
    public Result<PermissionEntity> save(@RequestBody PermissionEntity permissionentity) {
        return Result.ofSuccess(permissionService.save(permissionentity));
    }

    @GetMapping("/permission/{id}")
    public Result<PermissionEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(permissionService.find(id));
    }

    @GetMapping("/permission")
    public Result<List<PermissionEntity>> getAll() {
        return Result.ofSuccess(permissionService.findAll());
    }

    @DeleteMapping("/permission/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        permissionService.delete(id);
        return Result.ofSuccess();
    }

    @DeleteMapping("/permission")
    public Result deleteAll() {
        permissionService.deleteAll();
        return Result.ofSuccess();
    }

    @GetMapping("/permission/count")
    public Result<Long> count() {
        return Result.ofSuccess(permissionService.count());
    }
}