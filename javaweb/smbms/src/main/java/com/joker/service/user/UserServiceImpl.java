package com.joker.service.user;

import com.joker.dao.BaseDao;
import com.joker.dao.user.UserDao;
import com.joker.dao.user.UserDaoImpl;
import com.joker.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * service 是业务层：只负责处理对应的业务
 */
public class UserServiceImpl implements UserService{
    //业务层都会调入Dao 层，所以我们要引入Dao 层
    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override//用户登录
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection,userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }

        return user;
    }

    @Override//修改密码
    public boolean updatePwd(int id, String password) {
        Connection connection = null;
        boolean flag = false;//判断密码是否修改成功
        //修改密码
        try {
            connection = BaseDao.getConnection();
            if (userDao.updatePwd(connection,id,password) > 0){
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return flag;
    }

    @Override//获取用户的数量，即查询记录数
    public int getUserCount(String userName, int userRole) {
        Connection connection = null;
        int count = 0;

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection,userName,userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;

        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

}
