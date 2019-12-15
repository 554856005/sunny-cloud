package com.sunny.user.service.impl;

import com.sunny.user.entity.ResourceEntity;
import com.sunny.user.repository.ResourceRepo;
import com.sunny.user.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepo resourceRepo;

    @Override
    public ResourceEntity save(ResourceEntity resourceentity) {
        return resourceRepo.save(resourceentity);
    }

    @Override
    public Optional<ResourceEntity> find(String id) {
        return resourceRepo.findById(id);
    }

    @Override
    public List<ResourceEntity> findAll() {
        return resourceRepo.findAll();
    }

    @Override
    public List<ResourceEntity> findAll(Sort sort) {
        return resourceRepo.findAll(sort);
    }

    @Override
    public Page<ResourceEntity> findAll(Pageable pageable) {
        return resourceRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        resourceRepo.deleteById(id);
    }

    @Override
    public void delete(ResourceEntity resourceentity) {
        resourceRepo.delete(resourceentity);
    }

    @Override
    public void deleteAll() {
        resourceRepo.deleteAll();
    }

    @Override
    public long count() {
        return resourceRepo.count();
    }

}