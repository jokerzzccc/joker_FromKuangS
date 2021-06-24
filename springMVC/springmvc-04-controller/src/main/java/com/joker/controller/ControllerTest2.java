package com.joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//代表这个类会被spring接管
//@Controller 注解了的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
public class ControllerTest2 {
    @RequestMapping("/h2")
    public String test1(Model model){
        //Model,就是一个简化版的ModelAndView ，用的最多
        model.addAttribute("msg","ControllerTest2");
        return "hello";
    }
}
