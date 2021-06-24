package com.joker.lesson03;

import com.joker.lesson02.utils.JdbcUtils;

import java.sql.*;
import java.time.LocalDate;

/**
 * preparedStatement 的使用
 */
public class TestInsert {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = JdbcUtils.getConnection();
            //与 Statement 的区别
            // 使用 ? 占位符代替参数
            String sql = "INSERT INTO `users` (id,`NAME`,`PASSWORD`,`email`,birthday) values(?,?,?,?,?)";
//                    "VALUES(6,'joker','123456','abc@qq.com','2021-12-12')";
            statement = conn.prepareStatement(sql);//预编译SQL ，先写sql,然后不执行
            //手动给参数赋值
            statement.setInt(1,7);
            statement.setString(2,"evil");
            statement.setString(3,"12345");
            statement.setString(4,"kjj@dd.com");
            //注意点：sql.Date 数据库 java.sql.Date
            //      util.Date Java  new Date().getTime() 获得时间戳
            statement.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            //执行
            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,statement,null);
        }
    }
}
