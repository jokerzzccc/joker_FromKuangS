package com.joker.lesson04;

import com.joker.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IDEA处理事务
 */
public class TestTransaction01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;


        try {
            conn = JdbcUtils.getConnection();
            //关闭数据库的自动提交，会自动开启事务
            conn.setAutoCommit(false);

            String sql_1 = "update account set money = money-100 where name = 'A'";
            ps = conn.prepareStatement(sql_1);
            ps.executeUpdate();

//            int x=1/0;//报错，

            String sql_2 = "update account set money = money+100 where name = 'B'";
            ps = conn.prepareStatement(sql_2);
            ps.executeUpdate();

            //业务完毕，提交事务
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("转账成功");
        } catch (SQLException throwables) {
            try {
                conn.rollback();//如果失败，则回滚事务,不写也可以，因为失败默认回滚
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,ps,null);
        }
    }
}
