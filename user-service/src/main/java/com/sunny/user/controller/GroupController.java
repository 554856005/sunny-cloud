package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.entity.GroupEntity;
import com.sunny.user.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(value = "GroupController", produces = MediaType.ALL_VALUE)
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    @ApiOperation(value = "创建用户组")
    public Result<GroupEntity> save(@RequestBody GroupEntity groupentity) {
        return Result.ofSuccess(groupService.save(groupentity));
    }

    @GetMapping("/group/{id}")
    public Result<GroupEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(groupService.find(id));
    }

    @GetMapping("/group")
    public List<GroupEntity> getAll() {
        return groupService.findAll();
    }

    @DeleteMapping("/group/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        groupService.delete(id);
        return Result.ofSuccess();
    }

    @DeleteMapping("/group")
    public Result deleteAll() {
        groupService.deleteAll();
        return Result.ofSuccess();
    }

    @GetMapping("/group/count")
    public Result<Long> count() {
        return Result.ofSuccess(groupService.count());
    }
}