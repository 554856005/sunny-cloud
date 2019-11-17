package com.sunny.user.service.impl;

import com.sunny.user.entity.MenuEntity;
import com.sunny.user.repository.MenuRepo;
import com.sunny.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public MenuEntity save(MenuEntity menuentity) {
        return menuRepo.save(menuentity);
    }

    @Override
    public MenuEntity find(String id) {
        return menuRepo.getById(id);
    }

    @Override
    public List<MenuEntity> findAll() {
        return menuRepo.findAll();
    }

    @Override
    public List<MenuEntity> findAll(List<String> ids) {
        return menuRepo.findAllById(ids);
    }

    @Override
    public List<MenuEntity> findAll(Sort sort){
        return menuRepo.findAll(sort);
    }

    @Override
    public Page<MenuEntity> findAll(Pageable pageable){
        return menuRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    menuRepo.deleteById(id);
    }

    @Override
    public void delete(List<MenuEntity> entities) {
        menuRepo.deleteAll(entities);
    }

    @Override
    public void delete(MenuEntity menuentity) {
        menuRepo.delete(menuentity);
    }

    @Override
    public void deleteAll() {
        menuRepo.deleteAll();
    }

    @Override
    public long count() {
        return menuRepo.count();
    }

}