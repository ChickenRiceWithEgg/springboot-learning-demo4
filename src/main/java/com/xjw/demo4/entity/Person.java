package com.xjw.demo4.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@PropertySource(value = {"classpath:/application-dev.yml"})
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private String age;
    private String sex;
    private Date birth;
}
