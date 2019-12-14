package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.MenuEntity;
import com.sunny.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/menu")
    public Result<MenuEntity> save(@RequestBody MenuEntity menuentity) {
        return Result.ofSuccess(menuService.save(menuentity));
    }

    @GetMapping("/menu/{id}")
    public Result<MenuEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(menuService.find(id));
    }

    @GetMapping("/menu")
    public Result<List<MenuEntity>> getAll() {
        return Result.ofSuccess(menuService.findAll());
    }

    @DeleteMapping("/menu/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        menuService.delete(id);
        return Result.ofSuccess();
    }

    @DeleteMapping("/menu")
    public Result deleteAll() {
        menuService.deleteAll();
        return Result.ofSuccess();
    }

    @GetMapping("/menu/count")
    public Result<Long> count() {
        return Result.ofSuccess(menuService.count());
    }
}