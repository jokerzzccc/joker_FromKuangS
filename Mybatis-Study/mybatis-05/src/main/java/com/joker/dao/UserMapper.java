package com.joker.dao;

import com.joker.pojo.User;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数必须前必须加上@Param() 注解
    //注意：数据的参数传递，与@Param里的值一致
    @Select("select * from user where id =#{idp}")
    User getUserById(@Param("idp") int id);
    @Insert("insert into user values (#{id},#{name},#{password})")
    int addUser(User user);
    @Update("update user set name=#{name},pwd=#{password},where id=#{id}")
    int updateUser(User user);
    @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid") int id);

}
