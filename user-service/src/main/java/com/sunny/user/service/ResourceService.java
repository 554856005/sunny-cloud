package com.sunny.user.service;

import com.sunny.user.entity.ResourceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ResourceService {

    ResourceEntity save(ResourceEntity resourceentity);

    Optional<ResourceEntity> find(String id);

    List<ResourceEntity> findAll();

    List<ResourceEntity> findAll(Sort sort);

    Page<ResourceEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(ResourceEntity resourceentity);

    void deleteAll();

    long count();

}