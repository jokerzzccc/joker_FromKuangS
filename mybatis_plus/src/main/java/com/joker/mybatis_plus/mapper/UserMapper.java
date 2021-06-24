package com.joker.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.mybatis_plus.pojo.User;
import org.apache.ibatis.annotations.Mapper;

//在对应的mapper上面实现基本的类 BaseMapper
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //只需要写这个接口，所有的 CRUD 操作都已经完成。
}