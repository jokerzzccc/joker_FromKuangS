package com.joker.dao;

import com.joker.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("uid") int id);
}
