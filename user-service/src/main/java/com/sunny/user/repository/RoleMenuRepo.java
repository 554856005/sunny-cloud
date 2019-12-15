package com.sunny.user.repository;

import com.sunny.user.entity.relation.RoleMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRepo extends JpaRepository<RoleMenuEntity, String> {
}