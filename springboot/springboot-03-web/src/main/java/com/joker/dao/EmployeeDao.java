package com.joker.dao;

import com.joker.pojo.Department;
import com.joker.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工DAO
@Repository
public class EmployeeDao {
    //模拟数据库
    private static Map<Integer, Employee> employeeMap=null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap=new HashMap<>();//创建一个部门表
        employeeMap.put(101,new Employee(1,"张","111@com",0,new Department(101,"篮球"),new Date()));
        employeeMap.put(102,new Employee(2,"陈","222@com",1,new Department(102,"pingpong"),new Date()));
        employeeMap.put(103,new Employee(3,"孙","333@com",1,new Department(103,"music"),new Date()));
        employeeMap.put(104,new Employee(4,"李","444@com",0,new Department(104,"dance"),new Date()));
        employeeMap.put(105,new Employee(5,"王","555@com",0,new Department(105,"sing"),new Date()));
    }

    private static Integer initId=106;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }
    //删除员工通过id
    public void delete(Integer id) {
        employeeMap.remove(id);
    }
}
