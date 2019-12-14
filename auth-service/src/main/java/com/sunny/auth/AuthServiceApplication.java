package com.sunny.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @EnableResourceServer 表示该服务是oauth2资源服务
 * @EnableAuthorizationServer 表示该服务是oauth2鉴权服务
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
/** 把FeignXXService类注册上 @Autowired有效*/
@EnableFeignClients(basePackages = "com.sunny.auth.feign")
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
