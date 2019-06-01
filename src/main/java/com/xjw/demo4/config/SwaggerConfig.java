package com.xjw.demo4.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger配置文件
 */

@EnableWebMvc
@EnableSwagger2
@Data  //属性就不需要提供get/set方法了
@Configuration
@ConfigurationProperties(prefix = "swagger")
@ComponentScan(basePackages = {"com.xjw.demo4.controller"})
public class SwaggerConfig {
    private String title;
    private String description;
    private String version;

    private String name;
    private String url;
    private String email;

    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact(name, url, email);
        return new ApiInfoBuilder().title(title).description(description).contact(contact).version(version).build();
    }
}

