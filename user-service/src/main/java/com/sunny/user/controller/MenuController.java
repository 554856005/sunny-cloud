package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.MenuEntity;
import com.sunny.user.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/menu")
@Api(value = "MenuController", produces = MediaType.ALL_VALUE)
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/save")
    public Result<MenuEntity> save(@RequestBody MenuEntity menuentity) {
        return Result.ofSuccess(menuService.save(menuentity));
    }

    @GetMapping("/getById/{id}")
    public Result<MenuEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(menuService.find(id));
    }

    @GetMapping("/getAll")
    public Result<List<MenuEntity>> getAll() {
        return Result.ofSuccess(menuService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        menuService.delete(id);
        return Result.ofSuccess();
    }


    @GetMapping("/count")
    public Result<Long> count() {
        return Result.ofSuccess(menuService.count());
    }
}