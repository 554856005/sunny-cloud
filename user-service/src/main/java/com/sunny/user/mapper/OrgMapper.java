package com.sunny.user.mapper;

import com.sunny.user.dto.OrgDTO;
import com.sunny.user.entity.OrgEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @description: sunny-cloud OrgMapper
 * @date: 2019/12/15 6:33 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrgMapper {
    OrgMapper ORG_MAPPER = Mappers.getMapper(OrgMapper.class);

    OrgEntity toOrgEntity(OrgDTO d);
}
