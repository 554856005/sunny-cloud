package com.sunny.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Oauth2Config
 * 资源，授权
 * OAuth2 授权模式
 * 密码模式 password  一般用于都是可信的的情况，也就是说资源所有者，资源服务器，授权服务都是一家的
 * 客户端凭据 client credential
 * 授权码 authorization code
 * 隐式 implicit
 *
 * @author lijunsong
 * @date 2019/12/7 10:27
 * @since 1.0
 */
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //定义哪些客户可以注册到该服务
        clients.inMemory().withClient("clientId")
                .secret("clientSecret")
//                .secret(passwordEncoder().encode("clientSecret"))  //密码加密处理
                //支持的授权模式：密码模式，客户端凭证
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                //定义访问作用域，就是当用使用某一个scope授权之后，可根据不同的scope封装不同的user信息
                //比如webclient会封装角色，mobileclient封装角色和资源api，由开发人员定义即可
                .scopes("webClient", "mobileClient");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //使用默认的验证管理器和用户信息服务
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
