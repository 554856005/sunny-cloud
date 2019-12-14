package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.OrganizationEntity;
import com.sunny.user.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/organization")
    public Result<OrganizationEntity> save(@RequestBody OrganizationEntity entity) {
        return Result.ofSuccess(organizationService.save(entity));
    }

    @GetMapping("/organization/{id}")
    public Result<OrganizationEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(organizationService.find(id));
    }

    @GetMapping("/organization")
    public Result<List<OrganizationEntity>> getAll() {
        return Result.ofSuccess(organizationService.findAll());
    }

    @DeleteMapping("/organization/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        organizationService.delete(id);
        return Result.ofSuccess();
    }

    @DeleteMapping("/organization")
    public Result deleteAll() {
        organizationService.deleteAll();
        return Result.ofSuccess();
    }

    @GetMapping("/organization/count")
    public Result<Long> count() {
        return Result.ofSuccess(organizationService.count());
    }
}