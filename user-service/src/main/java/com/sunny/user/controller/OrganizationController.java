package com.sunny.user.controller;

import com.sunny.user.entity.OrganizationEntity;
import com.sunny.user.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationentityService;

    @PostMapping("/organizationentity")
    public OrganizationEntity save(@RequestBody OrganizationEntity organizationentity){
        return organizationentityService.save(organizationentity);
    }

    @GetMapping("/organizationentity/{id}")
    public OrganizationEntity getById(@PathVariable(value = "id") String id){
        return organizationentityService.find(id);
    }

    @GetMapping("/organizationentity")
    public List<OrganizationEntity> getAll(){
        return organizationentityService.findAll();
    }

    @DeleteMapping("/organizationentity/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        organizationentityService.delete(id);
    }

    @DeleteMapping("/organizationentity")
    public void deleteAll(){
        organizationentityService.deleteAll();
    }

    @GetMapping("/organizationentity/count")
    public long count(){
        return organizationentityService.count();
    }
}