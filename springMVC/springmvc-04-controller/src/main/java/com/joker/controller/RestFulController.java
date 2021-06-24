package com.joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
    // 原来的 ： http://localhost:8080/springmvc-04-controller/add?a=1&b=2
    //RestFul风格：http://localhost:8080/springmvc-04-controller/add/1/2
//    @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.DELETE)
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a , @PathVariable int b, Model model){
        int res= a+b;
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a , @PathVariable int b, Model model){
        int res= a+b;
        model.addAttribute("msg","结果2222为"+res);
        return "redirect:/index.jsp";
    }

}
