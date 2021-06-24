package com.joker.lesson03;

import com.joker.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * PreparedStatement
 */
public class TestUpdate {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = JdbcUtils.getConnection();
            //与 Statement 的区别
            // 使用 ? 占位符代替参数
            String sql = "update users set `NAME`=? where id=?";
            statement = conn.prepareStatement(sql);//预编译SQL ，先写sql,然后不执行
            //手动给参数赋值
            statement.setString(1,"joker2");
            statement.setInt(2,5);
            //执行
            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,statement,null);
        }
    }

}
