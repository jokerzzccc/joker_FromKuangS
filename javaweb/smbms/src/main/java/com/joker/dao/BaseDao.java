package com.joker.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//操作数据库 的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，类加载的时候就初始化了
    static{
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
//连接数据库
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
    //编写查询公共方法
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject 占位符从1开始，，但是我们的数组从0开始
            preparedStatement.setObject(i+1,params[i]);
        }
        //预编译的SQL，是直接执行，不用在这里传参
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    //编写增删改公共方法
    public static int execute(Connection connection,String sql,Object[] params,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject 占位符从1开始，，但是我们的数组从0开始
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }
    //关闭连接，释放资源
public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
    boolean flag = true;

    if (resultSet != null) {
        try {
            resultSet.close();
            //GC回收
            resultSet = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }
    }
    if (preparedStatement != null) {
        try {
            preparedStatement.close();
            //GC回收
            preparedStatement = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }
    }
    if (connection != null) {
        try {
            connection.close();
            //GC回收
            connection = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }
    }
    return flag;
}
}

