package com.sunny.auth.feign.impl;

import com.sunny.auth.feign.FeignUserService;
import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.common.dto.user.UserDTO;

import java.util.List;

/**
 * @description: sunny-cloud FeignUserServiceImpl
 * @date: 2019/12/14 11:52 PM
 * @author: JasonLi
 * @version: 1.0
 */
public class FeignUserServiceImpl implements FeignUserService {
    @Override
    public UserDTO findUserInfo(String loginName) {
        return null;
    }

    @Override
    public List<PermissionDTO> findPermissions(String userId) {
        return null;
    }
}
