package com.sunny.user.controller;

import com.sunny.common.utils.Result;
import com.sunny.user.dto.OrgDTO;
import com.sunny.user.entity.OrgEntity;
import com.sunny.user.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @PostMapping("/save")
    public Result<OrgEntity> save(@RequestBody OrgDTO dto) {
        return Result.ofSuccess(orgService.save(dto));
    }

    @GetMapping("/getById/{id}")
    public Result<OrgEntity> getById(@PathVariable(value = "id") String id) {
        return Result.ofSuccess(orgService.find(id));
    }

    @GetMapping("/getAll")
    public Result<List<OrgEntity>> getAll() {
        return Result.ofSuccess(orgService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable(value = "id") String id) {
        orgService.delete(id);
        return Result.ofSuccess();
    }


    @GetMapping("/count")
    public Result<Long> count() {
        return Result.ofSuccess(orgService.count());
    }
}