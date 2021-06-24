package com.joker.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.joker.JsonUtils;
import com.joker.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//@Controller
@RestController//类里的所有方法，都返回字符串，不走视图解析器
public class UserController {
    @RequestMapping("/j1")
//    @ResponseBody //这个注解就不会，走视图器，会直接返回字符串
    public String json1() throws JsonProcessingException {
        //json : ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "joker陈", 20);
        //转为json格式
        String s = mapper.writeValueAsString(user);
        return  s;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        //json : ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(1, "joker陈", 20);
        User user2 = new User(2, "joker陈", 20);
        User user3 = new User(3, "joker陈", 20);
        User user4 = new User(4, "joker陈", 20);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(users);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "hello";
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        Date date = new Date();
//ObjectMapper 时间解析后的默认格式是时间戳 timestamp
        return JsonUtils.getJson(date);
    }
}
