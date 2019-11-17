package com.sunny.user.service.impl;

import com.sunny.user.entity.OrganizationEntity;
import com.sunny.user.repository.OrganizationRepo;
import com.sunny.user.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    @Override
    public OrganizationEntity save(OrganizationEntity organizationentity) {
        return organizationRepo.save(organizationentity);
    }

    @Override
    public OrganizationEntity find(String id) {
        return organizationRepo.getById(id);
    }

    @Override
    public List<OrganizationEntity> findAll() {
        return organizationRepo.findAll();
    }

    @Override
    public List<OrganizationEntity> findAll(List<String> ids) {
        return organizationRepo.findAllById(ids);
    }

    @Override
    public List<OrganizationEntity> findAll(Sort sort){
        return organizationRepo.findAll(sort);
    }

    @Override
    public Page<OrganizationEntity> findAll(Pageable pageable){
        return organizationRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    organizationRepo.deleteById(id);
    }

    @Override
    public void delete(List<OrganizationEntity> entities) {
        organizationRepo.deleteAll(entities);
    }

    @Override
    public void delete(OrganizationEntity organizationentity) {
        organizationRepo.delete(organizationentity);
    }

    @Override
    public void deleteAll() {
        organizationRepo.deleteAll();
    }

    @Override
    public long count() {
        return organizationRepo.count();
    }

}