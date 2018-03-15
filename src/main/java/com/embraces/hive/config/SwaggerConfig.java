package com.embraces.hive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author sherlyxiao
 * @date Jan 18, 2018 6:46:39 PM
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.embraces.web.controller")
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
                .apis(RequestHandlerSelectors.basePackage("com.embraces.hive.controller")).paths(PathSelectors.any())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title("hive-kerberos测试api接口").version("1.0.0").termsOfServiceUrl("#")
                .description("hive-kerberos测试api接口@EmbraceSource").build();
    }

}
