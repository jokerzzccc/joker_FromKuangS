package com.joker.service.user;

import com.joker.pojo.User;

import java.util.List;

public interface UserService {
        //用户登录
        public User login(String userCode, String password);
        //根据User表的id 修改密码
        public boolean updatePwd(int id, String password);
        //获取用户的数量,即记录数
        public int getUserCount(String userName,int userRole);
        //根据条件查询用户列表

        public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
}
