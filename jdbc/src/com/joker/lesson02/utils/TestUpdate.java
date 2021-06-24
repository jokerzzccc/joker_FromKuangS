package com.joker.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = JdbcUtils.getConnection();
            statement = conn.createStatement();
            String sql = "update users set `NAME`='monster' ,`email`='hhhh@joker.com' where id = 1";
            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,statement,resultSet);
        }
    }
}
