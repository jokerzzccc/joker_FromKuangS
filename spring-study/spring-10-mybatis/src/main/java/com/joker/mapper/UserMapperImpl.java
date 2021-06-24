package com.joker.mapper;

import com.joker.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * 整合方式一 SqlSessionTemplate
 */
public class UserMapperImpl implements UserMapper{
    //整合spring之前，所有操作由sqlSession执行，整合之后，由SqlSessionTemplate执行
    //注入
    private SqlSessionTemplate sqlSession;
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectUser();
    }
}
