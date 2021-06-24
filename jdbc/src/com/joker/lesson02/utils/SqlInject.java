package com.joker.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * SQL注入问题示例
 */
public class SqlInject {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入姓名：");


        login("monster","123456");
//          login(" 'or'1=1"," 'or'1=1");//这就是典型的sql注入问题
    }

    // 登录业务
    public static void login(String username,String password) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = JdbcUtils.getConnection();
            statement = conn.createStatement();
            String sql = "select * from users where `NAME`='"+username+"' and `password`='"+password+"'";
            resultSet= statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("NAME"));
                System.out.println(resultSet.getString("password"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,statement,resultSet);
        }
    }

}
