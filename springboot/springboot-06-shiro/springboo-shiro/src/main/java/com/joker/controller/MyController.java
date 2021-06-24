package com.joker.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,shiro");
        return "index";
    }
    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }
    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String username,String pwd,Model model){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);

        try {
            subject.login(token);//执行登录的方法，如果没有异常，就ok了
            return "index";
        } catch (UnknownAccountException uae) {//用户名错误
            model.addAttribute("msg","There is no user with username of " + token.getPrincipal());
            return "login";
        } catch (IncorrectCredentialsException ice) {//密码错误
            model.addAttribute("msg","Password for account " + token.getPrincipal() + " was incorrect!");
            return "login";
        }

    }

    @RequestMapping("/unauthorized")
    @ResponseBody
    public String unauthorized(){
        return "未经过授权，无法访问 ";
    }
}
