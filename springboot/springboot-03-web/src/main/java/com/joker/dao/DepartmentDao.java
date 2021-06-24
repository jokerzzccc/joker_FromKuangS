package com.joker.dao;

import com.joker.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门Dao
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap=null;
    static {
        departmentMap=new HashMap<>();//创建一个部门表
        departmentMap.put(101,new Department(101,"篮球"));
        departmentMap.put(102,new Department(102,"pingpong"));
        departmentMap.put(103,new Department(103,"music"));
        departmentMap.put(104,new Department(104,"dance"));
        departmentMap.put(105,new Department(105,"sing"));
    }
    //获得部门所有信息
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
