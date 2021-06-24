package com.joker.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = JdbcUtils.getConnection();
            statement = conn.createStatement();
            String sql = "INSERT INTO `users` (id,`NAME`,`PASSWORD`,`email`,birthday)\n" +
                    "VALUES(6,'joker','123456','abc@qq.com','2021-12-12')";
            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("插入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,statement,resultSet);
        }
    }
}
