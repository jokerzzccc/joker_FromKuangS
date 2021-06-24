package com.joker.dao;


import com.joker.pojo.User;
import com.joker.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(7,"hhh","12314"));

//        List<User> users = mapper.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
//
//        User userById = mapper.getUserById(1);
//        System.out.println(userById);
        sqlSession.close();
    }
}
