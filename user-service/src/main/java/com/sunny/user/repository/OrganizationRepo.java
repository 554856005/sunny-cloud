package com.sunny.user.repository;

import com.sunny.user.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends JpaRepository<OrganizationEntity, String> {
    OrganizationEntity getById(String id);
}