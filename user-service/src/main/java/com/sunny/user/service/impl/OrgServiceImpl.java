package com.sunny.user.service.impl;

import com.sunny.user.dto.OrgDTO;
import com.sunny.user.entity.OrgEntity;
import com.sunny.user.repository.OrganizationRepo;
import com.sunny.user.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sunny.user.mapper.OrgMapper.ORG_MAPPER;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrganizationRepo organizationRepo;

    @Override
    public OrgEntity save(OrgDTO dto) {
        return organizationRepo.save(ORG_MAPPER.toOrgEntity(dto));
    }

    @Override
    public OrgEntity find(String id) {
        return organizationRepo.getById(id);
    }

    @Override
    public List<OrgEntity> findAll() {
        return organizationRepo.findAll();
    }

    @Override
    public List<OrgEntity> findAll(List<String> ids) {
        return organizationRepo.findAllById(ids);
    }

    @Override
    public List<OrgEntity> findAll(Sort sort) {
        return organizationRepo.findAll(sort);
    }

    @Override
    public Page<OrgEntity> findAll(Pageable pageable) {
        return organizationRepo.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        organizationRepo.deleteById(id);
    }

    @Override
    public void delete(List<OrgEntity> entities) {
        organizationRepo.deleteAll(entities);
    }

    @Override
    public void delete(OrgEntity organizationentity) {
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