package com.joker.dao;

import com.joker.pojo.User;

import java.util.List;
import java.util.Map;

//mybaits 用的是mapper,等价于Dao
public interface UserMapper {
    List<User> getUserList();
    //模糊查询
    List<User> getUserLike(String value);
    //根据id查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);
    //万能的Map
    int addUser2(Map<String,Object> map);
    //修改用户
    int updateUser(User user);
    //删除
    int deleteUser(int id);
}
