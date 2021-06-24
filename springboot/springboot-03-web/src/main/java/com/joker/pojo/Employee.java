package com.joker.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    //员工表
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0 女；1 男
    private Department department;
    private Date birth;
}
