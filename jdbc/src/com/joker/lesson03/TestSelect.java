package com.joker.lesson03;

import com.joker.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement
 */
public class TestSelect {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where id=?";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("NAME"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,preparedStatement,resultSet);
        }

    }
}
