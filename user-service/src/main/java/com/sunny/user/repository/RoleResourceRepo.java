package com.sunny.user.repository;

import com.sunny.user.entity.relation.RoleResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResourceRepo extends JpaRepository<RoleResourceEntity, String> {
}