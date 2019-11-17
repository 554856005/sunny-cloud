package com.sunny.user.service;

import com.sunny.user.entity.OrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrganizationService {

    OrganizationEntity save(OrganizationEntity organizationentity);

    OrganizationEntity find(String id);

    List<OrganizationEntity> findAll();

    List<OrganizationEntity> findAll(List<String> ids);

    List<OrganizationEntity> findAll(Sort sort);

    Page<OrganizationEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<OrganizationEntity> entities);

    void delete(OrganizationEntity organizationentity);

    void deleteAll();

    long count();

}