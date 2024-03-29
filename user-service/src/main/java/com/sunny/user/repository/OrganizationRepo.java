package com.sunny.user.repository;

import com.sunny.user.entity.OrgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends JpaRepository<OrgEntity, String> {
    OrgEntity getById(String id);
}