package com.xjw.demo4.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户模块")
public class SwaggerController {

    Logger log = LoggerFactory.getLogger(SwaggerController.class);

    @GetMapping("/hello")
    @ApiOperation(value = "测试Swagger")
    public String hello(){
        return "springboot-swagger";
    }
}
