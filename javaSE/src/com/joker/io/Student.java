package com.joker.io;

import javax.xml.namespace.QName;
import java.io.Serializable;

/**
 * Student 类
 * @author joker_chen
 * 要实现序列化，必须实现 Serializable 接口，里面啥也没有，写上就行
 */
public class Student implements Serializable {

    private static final long serialVersoinUID = 100L;//serialVersoinUID 序列化版本号ID

    private String name;
    private int age;

    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
