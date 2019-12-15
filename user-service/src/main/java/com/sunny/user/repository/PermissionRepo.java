package com.sunny.user.repository;

import com.sunny.user.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<PermissionEntity, String> {
    PermissionEntity getById(String id);

}