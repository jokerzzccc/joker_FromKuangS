package com.joker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class JdbcController {
    final JdbcTemplate jdbcTemplate;
    public JdbcController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql ="select * from mybatis.user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        return maps;
    }
    @GetMapping("/addUser")
    public  String addUser(){
        String sql="insert into mybatis.user values(10,'小明','111111')";
    int update = jdbcTemplate.update(sql);
    return "insert-ok";
}
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql="update mybatis.user set name=? ,pwd=? where id="+id;

        //封装
    Object[] objects = new Object[2];
    objects[0] = "小明2";
    objects[1] = "22222";
    jdbcTemplate.update(sql,objects);
    return "update ok";
}

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "delete-ok";
}
}
                            