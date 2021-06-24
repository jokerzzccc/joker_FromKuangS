package com.joker.annotation;

public class Person {

    @PersonInfo(name = "joker",age = 20,sex = "哥哥")
    public void show(String name,int age,String sex){
        System.out.println(name +"-----" + age +"--------" + sex);
    }
}
