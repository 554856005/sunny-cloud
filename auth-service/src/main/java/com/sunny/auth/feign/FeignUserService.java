package com.sunny.auth.feign;

import com.sunny.auth.feign.impl.FeignUserServiceImpl;
import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.common.dto.user.UserDTO;
import com.sunny.common.utils.Consts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @description: sunny-cloud UserInfoService
 * @date: 2019/12/14 11:06 PM
 * @author: JasonLi
 * @version: 1.0
 */
@FeignClient(value = Consts.USER_SERVICE, fallback = FeignUserServiceImpl.class)
public interface FeignUserService {

    @GetMapping(value = "/user/user/findUserInfo")
    UserDTO findUserInfo(String loginName);

    @GetMapping(value = "/user/permission/findPermissions")
    List<PermissionDTO> findPermissions(String userId);
}
