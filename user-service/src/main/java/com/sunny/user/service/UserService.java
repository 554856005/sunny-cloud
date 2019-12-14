package com.sunny.user.service;

import com.sunny.common.dto.user.UserDTO;
import com.sunny.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    UserEntity save(UserEntity userentity);

    UserEntity find(String id);

    List<UserEntity> findAll();

    List<UserEntity> findAll(List<String> ids);

    List<UserEntity> findAll(Sort sort);

    Page<UserEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<UserEntity> entities);

    void delete(UserEntity userentity);

    void deleteAll();

    long count();

    UserDTO findUserInfo(String loginName);
}