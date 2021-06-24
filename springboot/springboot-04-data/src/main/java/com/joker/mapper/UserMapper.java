package com.joker.mapper;

import com.joker.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//也可以在，主程序，添加，扫描mapper包，@MapperScan("com.joker.mapper")
@Mapper//这个注解表示这个一个mybaits的mapper接口
@Repository
public interface UserMapper {
    public List<User> queryUserList();

}
