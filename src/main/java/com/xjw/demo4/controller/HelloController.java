package com.xjw.demo4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


/**
 * GET 和 POST方式传参
 */
@RestController
public class HelloController {

    Logger log = LoggerFactory.getLogger(HelloController.class);


    /**
     * @PathVariable注解      URL中有变量，使用{}包含
     */
    //或者@GetMapping(value = "/hello/{pathName}")
    @RequestMapping(value = "/hello/{pathName}", method = RequestMethod.GET)
    public String hello(@PathVariable("pathName") String pathName){
        return "hello " + pathName;
    }


    /**
     * @RequestParam注解
     * 前端传过来的参数名需要等于@RequestParam中的value
     */
    @RequestMapping(value="/hello2", method = RequestMethod.GET)
    public String hello2(@RequestParam(value = "paramName", defaultValue = "默认值", required = false) String paramName){
        return "hello " + paramName;
    }


     // 不使用@RequestParam注解，只要前端传的参数和方法的形参的变量名一样就可以

    /**
     * 使用GET方法进行参数传递
     *
     */
    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3(String name){
        return "hello " + name + "==不使用@RequestParam注解";
    }

    /**
     * 使用POST方法进行参数传递
     *
     */
    @RequestMapping(value="/hello4", method = RequestMethod.POST)
    public String hello4(String name, String age){
        log.info("name="+name+", age="+age);
        return "name="+name+", age="+age;
    }


}
