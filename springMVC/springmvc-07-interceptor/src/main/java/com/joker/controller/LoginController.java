package com.joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户的信息存在session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }
//注销session
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userLoginInfo");
        return "main";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/goLogin")
    public String Login(){
        return "/login";
    }
}
