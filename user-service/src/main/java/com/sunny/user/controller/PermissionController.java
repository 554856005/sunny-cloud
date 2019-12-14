package com.sunny.user.controller;

import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.common.utils.Result;
import com.sunny.user.entity.PermissionEntity;
import com.sunny.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping(value = "/findPermissions")
    public List<PermissionDTO> findPermissions(String userId) {
        return permissionService.findPermissions(userId);
    }

    @PostMapping("/save")
    public Result<PermissionEntity> save(@RequestBody PermissionEntity permissionentity) {
        return Result.ofSuccess(permissionService.save(permissionentity));
    }

    @GetMapping("/getById/{id}")
    public Result<PermissionEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(permissionService.find(id));
    }

    @GetMapping("/getAll")
    public Result<List<PermissionEntity>> getAll() {
        return Result.ofSuccess(permissionService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        permissionService.delete(id);
        return Result.ofSuccess();
    }

    @GetMapping("/count")
    public Result<Long> count() {
        return Result.ofSuccess(permissionService.count());
    }
}