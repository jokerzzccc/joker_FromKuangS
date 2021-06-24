package com.joker.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {

        public static void main(String[] args) {

            Connection conn = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                conn = JdbcUtils.getConnection();
                statement = conn.createStatement();
                String sql = "select * from users where id =1";
                resultSet= statement.executeQuery(sql);
               while (resultSet.next()){
                   System.out.println(resultSet.getString("NAME"));
               }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JdbcUtils.release(conn,statement,resultSet);
            }
        }
}

