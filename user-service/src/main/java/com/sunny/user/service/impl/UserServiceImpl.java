package com.sunny.user.service.impl;

import com.sunny.user.entity.UserEntity;
import com.sunny.user.repository.UserRepo;
import com.sunny.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity save(UserEntity userentity) {
        return userRepo.save(userentity);
    }

    @Override
    public UserEntity find(String id) {
        return userRepo.getById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<UserEntity> findAll(List<String> ids) {
        return userRepo.findAllById(ids);
    }

    @Override
    public List<UserEntity> findAll(Sort sort){
        return userRepo.findAll(sort);
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable){
        return userRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    userRepo.deleteById(id);
    }

    @Override
    public void delete(List<UserEntity> entities) {
        userRepo.deleteAll(entities);
    }

    @Override
    public void delete(UserEntity userentity) {
        userRepo.delete(userentity);
    }

    @Override
    public void deleteAll() {
        userRepo.deleteAll();
    }

    @Override
    public long count() {
        return userRepo.count();
    }

}