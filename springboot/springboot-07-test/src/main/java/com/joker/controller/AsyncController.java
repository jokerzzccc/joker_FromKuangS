package com.joker.controller;

import com.joker.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        asyncService.hello();
        return "ok";
    }
}
