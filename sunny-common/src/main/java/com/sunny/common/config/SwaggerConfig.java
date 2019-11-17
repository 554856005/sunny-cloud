package com.sunny.common.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-12 22:45
 */
@EnableSwagger2
@Configuration
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    /**
     * 创建Api详细信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Talent Swagger2 Restful API")
                //创建人
                .contact(new Contact("JasonLi", "", "55485600@qq.com"))
                .version("1.0")
                .description("API")
                .build();
    }

    /**
     * @Qualifier 表明使用@Autowired注解的controllerPackage动态加载controller类路径
     * @Resource同上 开启Swagger, 扫描controller包
     */
    @Bean
    public Docket createRestApi(@Qualifier("controllerPackage") String controllerPackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //包路径
                .apis(RequestHandlerSelectors.basePackage(controllerPackage))
                .paths(PathSelectors.any())
                .build();
    }
}
