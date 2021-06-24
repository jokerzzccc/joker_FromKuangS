package com.joker.lesson01;

import java.sql.*;

public class jdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 加载驱动
        //原本的写法是 DriverManager.registerDriver(new com.mysql.jdbc.Driver());,但最好用下面一种

        Class.forName("com.mysql.jdbc.Driver");//固定写法，加载驱动
        //2. 用户信息和url
        //useUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String name = "root";
        String password = "123456";
        //3. 连接成功，数据库对象 Connection 代表数据库
        Connection connection = DriverManager.getConnection(url, name, password);

        //4. 执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5. 执行sql的对象，去执行sql，可能存在结果
        //所有的删除和插入都叫更新update()
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);//返回结果集，是一个链表的形式
        //结果集中封装了我们查询的全部的结果

        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("NAME"));
            System.out.println("pwd="+resultSet.getObject("PASSWORD"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));

        }

        //6. 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
