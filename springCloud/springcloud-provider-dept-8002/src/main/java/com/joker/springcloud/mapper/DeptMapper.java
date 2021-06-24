package com.joker.springcloud.mapper;

import com.joker.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    //默认修饰符就是public 所以也可以不用写
    public boolean addDept(Dept dept);
    Dept queryById(Long id);
    List<Dept> queryAll();
}
