package com.sunny.user.controller;

import com.sunny.user.entity.GroupEntity;
import com.sunny.user.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class GroupController {

    @Autowired
    private GroupService groupentityService;

    @PostMapping("/groupentity")
    public GroupEntity save(@RequestBody GroupEntity groupentity){
        return groupentityService.save(groupentity);
    }

    @GetMapping("/groupentity/{id}")
    public GroupEntity getById(@PathVariable(value = "id") String id){
        return groupentityService.find(id);
    }

    @GetMapping("/groupentity")
    public List<GroupEntity> getAll(){
        return groupentityService.findAll();
    }

    @DeleteMapping("/groupentity/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        groupentityService.delete(id);
    }

    @DeleteMapping("/groupentity")
    public void deleteAll(){
        groupentityService.deleteAll();
    }

    @GetMapping("/groupentity/count")
    public long count(){
        return groupentityService.count();
    }
}