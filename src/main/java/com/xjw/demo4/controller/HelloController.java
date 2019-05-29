package com.xjw.demo4.controller;

import com.xjw.demo4.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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

    /**
     *  使用POST方法，在http的请求体中设置内容，并在控制台中打印出来
     */
    @PostMapping("/postString")
    public String postString(HttpServletRequest request){
        ServletInputStream sis = null;
        StringBuilder sb = null;
        try {
            sis = request.getInputStream();
            sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = sis.read(buf)) != -1){
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(sis != null){
                    sis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 使用@RequestBody注解，接受http请求体中的JSON数据，与entity类映射
     */
    @PostMapping("/user")
    @ResponseBody   //有了ResponseBody，就可以返回String，Map类型等到前台
    public Map<String, Object> getUser(@RequestBody User user){     //有了RequestBody，就可以接受前台传来的JSON类型数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        log.info(map.toString());
        return map;
    }



}
