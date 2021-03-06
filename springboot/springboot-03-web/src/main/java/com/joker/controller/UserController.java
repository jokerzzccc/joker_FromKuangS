package com.joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        Model model, HttpSession session){
        //具体的业务，
        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("loginUser",username);
                return "redirect:/main.html";
        }else {
            model.addAttribute("msg","错误");
            return "index";
        }
    }
}
