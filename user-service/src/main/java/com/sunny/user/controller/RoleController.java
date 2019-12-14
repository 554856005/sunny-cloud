package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.RoleEntity;
import com.sunny.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public Result<RoleEntity> save(@RequestBody RoleEntity roleentity) {
        return Result.ofSuccess(roleService.save(roleentity));
    }

    @GetMapping("/role/{id}")
    public Result<RoleEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(roleService.find(id));
    }

    @GetMapping("/role")
    public Result<List<RoleEntity>> getAll() {
        return Result.ofSuccess(roleService.findAll());
    }

    @DeleteMapping("/role/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        roleService.delete(id);
        return Result.ofSuccess();
    }

    @DeleteMapping("/role")
    public Result deleteAll() {
        roleService.deleteAll();
        return Result.ofSuccess();
    }

    @GetMapping("/role/count")
    public Result<Long> count() {
        return Result.ofSuccess(roleService.count());
    }
}