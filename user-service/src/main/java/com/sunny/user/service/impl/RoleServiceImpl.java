package com.sunny.user.service.impl;

import com.sunny.user.entity.RoleEntity;
import com.sunny.user.repository.RoleRepo;
import com.sunny.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public RoleEntity save(RoleEntity roleentity) {
        return roleRepo.save(roleentity);
    }

    @Override
    public RoleEntity find(String id) {
        return roleRepo.getById(id);
    }

    @Override
    public List<RoleEntity> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public List<RoleEntity> findAll(List<String> ids) {
        return roleRepo.findAllById(ids);
    }

    @Override
    public List<RoleEntity> findAll(Sort sort){
        return roleRepo.findAll(sort);
    }

    @Override
    public Page<RoleEntity> findAll(Pageable pageable){
        return roleRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    roleRepo.deleteById(id);
    }

    @Override
    public void delete(List<RoleEntity> entities) {
        roleRepo.deleteAll(entities);
    }

    @Override
    public void delete(RoleEntity roleentity) {
        roleRepo.delete(roleentity);
    }

    @Override
    public void deleteAll() {
        roleRepo.deleteAll();
    }

    @Override
    public long count() {
        return roleRepo.count();
    }

}