package com.sunny.user.service;

import com.sunny.user.entity.GroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GroupService {

    GroupEntity save(GroupEntity groupentity);

    GroupEntity find(String id);

    Page<GroupEntity> findAll(Pageable page);

    List<GroupEntity> findAll(List<String> ids);

    List<GroupEntity> findAll(Sort sort);

    void delete(String id);

    void delete(List<GroupEntity> entities);

    void delete(GroupEntity groupentity);

    void deleteAll();

    long count();

}