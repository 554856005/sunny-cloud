package com.sunny.user.repository;

import com.sunny.user.entity.relation.RoleOrgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleOrgRepo extends JpaRepository<RoleOrgEntity, String> {
}