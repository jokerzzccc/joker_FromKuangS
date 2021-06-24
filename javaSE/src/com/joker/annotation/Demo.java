package com.joker.annotation;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        //1 获取类对象
        Class<?> class1 = Class.forName("com.joker.annotation.Person");
        //2 获取方法
        Method showMethod = class1.getMethod("show", String.class, int.class, String.class);
        //3 获取方法上面的注解信息
        PersonInfo annotation = showMethod.getAnnotation(PersonInfo.class);
        //4 打印注解信息 会出现异常，因为 annotation 默认为null，使用元注解解决
        System.out.println(annotation.name());
        System.out.println(annotation.age());
        System.out.println(annotation.sex());

        //5 调用方法
        Person person = (Person) class1.newInstance();
        showMethod.invoke(person,annotation.name(),annotation.age(),annotation.sex());

  }
}
