package com.sunny.user;

import com.sunny.common.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
/** 加载配置类，swagger 才能正常访问 */
@Import({SwaggerConfig.class})
public class UserServiceApplication {
    @Bean
    public String controllerPackage() {
        return "com.sunny.user.controller";
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
