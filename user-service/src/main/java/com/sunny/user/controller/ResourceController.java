package com.sunny.user.controller;

import com.sunny.common.dto.PageDTO;
import com.sunny.common.utils.Result;
import com.sunny.user.entity.ResourceEntity;
import com.sunny.user.service.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/save")
    @ApiOperation(value = "保存资源")
    public Result<ResourceEntity> save(@RequestBody ResourceEntity entity) {
        return Result.ofSuccess(resourceService.save(entity));
    }

    @GetMapping("/getById/{id}")
    public Result<ResourceEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(resourceService.find(id));
    }

    @GetMapping("/getAll")
    public Result<List<ResourceEntity>> getAll(@RequestBody @Valid PageDTO pageDTO) {
        return Result.ofSuccess(resourceService.findAll(pageDTO.getPageable()));
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        resourceService.delete(id);
        return Result.ofSuccess();
    }

    @GetMapping("/count")
    public Result<Long> count() {
        return Result.ofSuccess(resourceService.count());
    }
}