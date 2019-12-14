package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.RoleEntity;
import com.sunny.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public Result<RoleEntity> save(@RequestBody RoleEntity roleentity) {
        return Result.ofSuccess(roleService.save(roleentity));
    }

    @GetMapping("/getById/{id}")
    public Result<RoleEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(roleService.find(id));
    }

    @GetMapping("/getAll")
    public Result<List<RoleEntity>> getAll() {
        return Result.ofSuccess(roleService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        roleService.delete(id);
        return Result.ofSuccess();
    }

    @GetMapping("/count")
    public Result<Long> count() {
        return Result.ofSuccess(roleService.count());
    }
}