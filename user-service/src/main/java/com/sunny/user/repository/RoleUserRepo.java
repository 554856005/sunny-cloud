package com.sunny.user.repository;

import com.sunny.user.entity.relation.RoleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepo extends JpaRepository<RoleUserEntity, String> {
}