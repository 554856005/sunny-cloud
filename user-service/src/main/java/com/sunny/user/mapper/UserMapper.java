package com.sunny.user.mapper;

import com.sunny.common.dto.user.UserDTO;
import com.sunny.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @description: sunny-cloud UserMapper
 * @date: 2019/12/15 1:51 AM
 * @author: JasonLi
 * @version: 1.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(UserEntity userEntity);
}
