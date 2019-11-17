package com.sunny.user.service;

import com.sunny.user.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RoleService {

    RoleEntity save(RoleEntity roleentity);

    RoleEntity find(String id);

    List<RoleEntity> findAll();

    List<RoleEntity> findAll(List<String> ids);

    List<RoleEntity> findAll(Sort sort);

    Page<RoleEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<RoleEntity> entities);

    void delete(RoleEntity roleentity);

    void deleteAll();

    long count();

}