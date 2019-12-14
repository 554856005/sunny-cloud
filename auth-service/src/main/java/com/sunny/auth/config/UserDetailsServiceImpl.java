package com.sunny.auth.config;

import com.sunny.auth.feign.FeignUserService;
import com.sunny.common.dto.user.PermissionDTO;
import com.sunny.common.dto.user.UserDTO;
import com.sunny.common.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: sunny-cloud UserInfoServiceImpl
 * @date: 2019/12/14 11:07 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    FeignUserService feignUserService;

    /**
     * 查询数据库登录
     *
     * @param loginName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        UserDTO userDTO = feignUserService.findUserInfo(loginName);
        //验证账号是否存在
        if (null == userDTO) {
            throw new UsernameNotFoundException(Consts.NO_USER_MSG);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        //获取用户权限
        List<PermissionDTO> permissions = feignUserService.findPermissions(userDTO.getId());
        //设置用户权限
        permissions.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName())));

        //返回用户认证
        return new User(userDTO.getLoginName(), userDTO.getPassword(), authorities);
    }
}
