package com.joker.controller;
import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","hello joker ,springmvc");
        return "hello";//返回的视图名，会被视图解析器处理
    }
}
