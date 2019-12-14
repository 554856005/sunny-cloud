package com.sunny.user.service.impl;

import com.sunny.user.entity.GroupEntity;
import com.sunny.user.repository.GroupRepo;
import com.sunny.user.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepo groupRepo;

    @Override
    public GroupEntity save(GroupEntity groupentity) {
        return groupRepo.save(groupentity);
    }

    @Override
    public GroupEntity find(String id) {
        return groupRepo.getById(id);
    }


    @Override
    public List<GroupEntity> findAll(List<String> ids) {
        return groupRepo.findAllById(ids);
    }

    @Override
    public List<GroupEntity> findAll(Sort sort) {
        return groupRepo.findAll(sort);
    }

    @Override
    public Page<GroupEntity> findAll(Pageable pageable) {
        return groupRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        groupRepo.deleteById(id);
    }

    @Override
    public void delete(List<GroupEntity> entities) {
        groupRepo.deleteAll(entities);
    }

    @Override
    public void delete(GroupEntity groupentity) {
        groupRepo.delete(groupentity);
    }

    @Override
    public void deleteAll() {
        groupRepo.deleteAll();
    }

    @Override
    public long count() {
        return groupRepo.count();
    }

}