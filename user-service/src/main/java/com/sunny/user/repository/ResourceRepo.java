package com.sunny.user.repository;

import com.sunny.user.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends JpaRepository<ResourceEntity, String> {
}