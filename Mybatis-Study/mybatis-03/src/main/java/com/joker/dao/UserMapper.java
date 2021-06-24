package com.joker.dao;

import com.joker.pojo.User;

import java.util.List;

//mybaits 用的是mapper,等价于Dao
public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);
    //删除
    int deleteUser(int id);
}
