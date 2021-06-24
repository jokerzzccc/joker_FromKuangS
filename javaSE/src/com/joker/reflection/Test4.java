package com.joker.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 发射获取注解信息
 */
public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> class1 = Class.forName("com.joker.reflection.Student2");

        //通过反射获取注解
        Annotation[] annotations = class1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解 value 的值
        TableJoker tableJoker = class1.getAnnotation(TableJoker.class);
        String value = tableJoker.value();
        System.out.println(value);

        //获得类指定的注解,即获得指定类的指定属性的注解
        Field name = class1.getDeclaredField("id");
        FieldJoker annotation = name.getAnnotation(FieldJoker.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }
}
@TableJoker("db_student")
class Student2{
    @FieldJoker(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldJoker(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldJoker(columnName = "db_name",type = "varchar",length = 4)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TableJoker{
    String value();
}
//属性的注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldJoker{
    String columnName();
    String type();
    int length();
}
