package com.joker.controller;

import com.alibaba.fastjson.JSON;
import com.joker.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }
    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param->"+name);
        if ("joker".equals(name)){
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }

    }
    @RequestMapping("/a2")
    public String a2(){
        List<User> users = new ArrayList<>();
        users.add(new User("joker",30,"male"));
        users.add(new User("python",30,"male"));
        users.add(new User("java",30,"male"));
        String str1 = JSON.toJSONString(users);
        return str1;

    }
    @RequestMapping("/a3")
    public String ajax3(String name,String pwd){
        String msg = "";
        //模拟数据库中存在数据,本来的name,pwd，应该是去数据库查，走service层
        if (name!=null){
            if ("admin".equals(name)){
                msg = "OK";
            }else {
                msg = "用户名输入错误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg = "OK";
            }else {
                msg = "密码输入有误";
            }
        }
        return msg; //由于@RestController注解，将msg转成json格式返回
    }
}
