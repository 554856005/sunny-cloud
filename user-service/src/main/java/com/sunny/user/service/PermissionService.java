package com.sunny.user.service;

import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.user.entity.PermissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PermissionService {

    PermissionEntity save(PermissionEntity permissionentity);

    PermissionEntity find(String id);

    List<PermissionEntity> findAll();

    List<PermissionEntity> findAll(List<String> ids);

    List<PermissionEntity> findAll(Sort sort);

    Page<PermissionEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<PermissionEntity> entities);

    void delete(PermissionEntity permissionentity);

    void deleteAll();

    long count();

    List<PermissionDTO> findPermissions(String userId);
}