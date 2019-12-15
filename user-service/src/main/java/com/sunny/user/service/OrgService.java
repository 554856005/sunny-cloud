package com.sunny.user.service;

import com.sunny.user.dto.OrgDTO;
import com.sunny.user.entity.OrgEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrgService {

    OrgEntity save(OrgDTO dto);

    OrgEntity find(String id);

    List<OrgEntity> findAll();

    List<OrgEntity> findAll(List<String> ids);

    List<OrgEntity> findAll(Sort sort);

    Page<OrgEntity> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<OrgEntity> entities);

    void delete(OrgEntity organizationentity);

    void deleteAll();

    long count();

}