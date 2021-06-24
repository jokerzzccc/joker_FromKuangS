package com.joker.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Blog {
    private String id;
    private String title;
    private Date createTime;//这个属性名和字段名不一致,需要在配置文件里配置 mapUnderscoreToCamelCase
    private String author;
    private int views;

}
