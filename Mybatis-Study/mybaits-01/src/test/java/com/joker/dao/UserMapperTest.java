package com.joker.dao;

import com.joker.pojo.User;
import com.joker.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        //方式一：getMapper()
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        //方式二：老方法，看看就好
//        List<User> objects = sqlSession.selectList("com.joker.dao.UserMapper.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }

        //关闭
        sqlSession.close();
    }
    //模糊查询
    @Test
    public void test_getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserLike("张");
        System.out.println(user);

        sqlSession.close();
    }
    @Test
    public void test_getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);

        sqlSession.close();
    }
    //增删改，必须提交事务
    @Test
    public void test_addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int joker = mapper.addUser(new User(4, "joker", "342343"));
        System.out.println(joker);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    //万能的Map
    @Test
    public void test_addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",5);
        map.put("username","kkkk");
        map.put("userpwd","dfdf");
        mapper.addUser2(map);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int joker = mapper.updateUser(new User(4, "monster", "1111111"));
        System.out.println(joker);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int joker = mapper.deleteUser(4);
        System.out.println(joker);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
