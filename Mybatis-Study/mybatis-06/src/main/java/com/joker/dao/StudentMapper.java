package com.joker.dao;

import com.joker.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有 的学生信息，以及对应的老师信息
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
