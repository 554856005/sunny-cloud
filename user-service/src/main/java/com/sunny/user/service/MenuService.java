package com.sunny.user.service;

import com.sunny.user.entity.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MenuService {

    MenuEntity save(MenuEntity menuentity);

    MenuEntity find(String id);

    List<MenuEntity> findAll();

    List<MenuEntity> findAll(List<String> ids);

    List<MenuEntity> findAll(Sort sort);

    Page<MenuEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<MenuEntity> entities);

    void delete(MenuEntity menuentity);

    void deleteAll();

    long count();

}