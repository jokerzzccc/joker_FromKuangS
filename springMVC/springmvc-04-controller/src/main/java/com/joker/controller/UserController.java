package com.joker.controller;

import com.joker.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("name2") String name, Model model){
        //1. 接收前端参数
        System.out.println("接收到的前端参数为" + name);
        //2 将返回的结果传给前端
        model.addAttribute("msg",name);
        //3 跳转视图
        return "hello";
    }
    //前端接收的是一个对象：id,name,age
    /*
    1. 接收前端用户传递的参数，判断参数的名字，假设名字在方法上，可以直接使用
    2. 假设传递的是一个对象User,匹配User 对象字段名，如果名字一直，则ok,否则匹配不到
     */
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "hello";
    }
    @GetMapping("/t3")
    public String test3(ModelMap modelMap){

            return "hello";
    }

}
