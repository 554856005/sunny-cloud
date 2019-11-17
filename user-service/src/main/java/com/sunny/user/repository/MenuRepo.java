package com.sunny.user.repository;

import com.sunny.user.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuEntity, String> {
    MenuEntity getById(String id);
}