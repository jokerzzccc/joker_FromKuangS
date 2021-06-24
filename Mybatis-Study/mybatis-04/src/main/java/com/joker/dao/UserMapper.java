package com.joker.dao;

import com.joker.pojo.User;

import java.util.List;
import java.util.Map;

//mybaits 用的是mapper,等价于Dao
public interface UserMapper {
    //根据id查询用户
    User getUserById(int id);
    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
    //分页二,早些年的，了解就好
    List<User> getUserByRowBounds();

}
