package com.sunny.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfig
 * 先检验用户的账号是否正确，在Oauth2Config配置认证拦截处理
 *
 * @author JasonLi
 * @date 2019/12/7 10:43
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
/**  对全部方法进行验证 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    /**
     * 必须配置，不然SpringBoot会自动配置一个AuthenticationManager，覆盖掉内存中的用户
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        //使用内存存放用户信息
        //        builder.inMemoryAuthentication()
//                .withUser("user")
//                .password("123456")
////                .password(passwordEncoder.encode("123456"))  //密码加密处理
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("123456")
//                .roles("USER", "ADMIN");
        //使用数据库
        builder.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/oauth/checkToken");
    }
}
