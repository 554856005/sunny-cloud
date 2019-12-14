package com.sunny.user.service.impl;

import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.user.entity.PermissionEntity;
import com.sunny.user.repository.PermissionRepo;
import com.sunny.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sunny.user.mapper.PermissionMapper.PERMISSION_MAPPER;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public PermissionEntity save(PermissionEntity permissionentity) {
        return permissionRepo.save(permissionentity);
    }

    @Override
    public PermissionEntity find(String id) {
        return permissionRepo.getById(id);
    }

    @Override
    public List<PermissionEntity> findAll() {
        return permissionRepo.findAll();
    }

    @Override
    public List<PermissionEntity> findAll(List<String> ids) {
        return permissionRepo.findAllById(ids);
    }

    @Override
    public List<PermissionEntity> findAll(Sort sort) {
        return permissionRepo.findAll(sort);
    }

    @Override
    public Page<PermissionEntity> findAll(Pageable pageable) {
        return permissionRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        permissionRepo.deleteById(id);
    }

    @Override
    public void delete(List<PermissionEntity> entities) {
        permissionRepo.deleteAll(entities);
    }

    @Override
    public void delete(PermissionEntity permissionentity) {
        permissionRepo.delete(permissionentity);
    }

    @Override
    public void deleteAll() {
        permissionRepo.deleteAll();
    }

    @Override
    public long count() {
        return permissionRepo.count();
    }

    @Override
    public List<PermissionDTO> findPermissions(String userId) {
        return PERMISSION_MAPPER.toPermissionDTOs(permissionRepo.findByUserId(userId));
    }

}