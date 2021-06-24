package com.joker.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分布式的实体类，都必须实现序列化
 * ORM
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private Long deptno;//主键
    private String dname;
    //db_source 字段：是这个数据存在哪个数据库 的字段
    //因为微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;
    //有参构造，只有dname 是因为，deptno主键自增，db_source 自动生成
    public Dept(String dname) {
        this.dname = dname;
    }

    /*
    链式写法
    Dept dept = new Dept();
    dept.setDeptno().setDname()....;
     */
}
