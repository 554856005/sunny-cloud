package com.sunny.user.repository;

import com.sunny.user.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<GroupEntity, String> {
    GroupEntity getById(String id);
}