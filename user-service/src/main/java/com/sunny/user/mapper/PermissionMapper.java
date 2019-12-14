package com.sunny.user.mapper;

import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.user.entity.PermissionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

/**
 * @description: sunny-cloud PermissionMapper
 * @date: 2019/12/15 2:20 AM
 * @author: JasonLi
 * @version: 1.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PermissionMapper {
    PermissionMapper PERMISSION_MAPPER = Mappers.getMapper(PermissionMapper.class);

    PermissionDTO toPermissionDTO(PermissionEntity entity);

    List<PermissionDTO> toPermissionDTOs(Collection<PermissionEntity> entities);

}
