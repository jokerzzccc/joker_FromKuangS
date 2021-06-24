package com.joker.dao;

import com.joker.pojo.User;
import com.joker.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

static Logger logger = Logger.getLogger(UserMapperTest.class);
@Test
public void testLimit(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    HashMap<String, Integer> map = new HashMap<>();
    map.put("startIndex",0);
    map.put("pageSize",2);
    List<User> userByLimit = mapper.getUserByLimit(map);
    for (User user : userByLimit) {
        System.out.println(user);
    }
    sqlSession.close();

}
@Test
public void testRowBounds(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    RowBounds rowBounds = new RowBounds(1, 2);
//通过java代码层面实现分页
    List<Object> userlist = sqlSession.selectList("com.joker.dao.UserMapper.getUserByRowBounds",null,rowBounds);
    for (Object o : userlist) {
        System.out.println(o);
    }
    sqlSession.close();
}
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
    @Test
    public void testLog4j(){
        //常用的三个
        logger.info("info: 进入了 log4j");//也就等价于输出，测试的时候用
        logger.debug("degug：进入了 log4j");//debug的时候用
        logger.error("error:get in error");//try catch里面用
    }
}
