package com.joker.swagger.controller;

import com.joker.swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello swagger";
    }
    //只要我们的接口中，返回值中存在实体类，他就会被扫描到swagger中

    @GetMapping("/user")
    public User user(){
        return new User();
    }

}
