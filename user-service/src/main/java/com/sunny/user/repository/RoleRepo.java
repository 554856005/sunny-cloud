package com.sunny.user.repository;

import com.sunny.user.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, String> {
    RoleEntity getById(String id);
}