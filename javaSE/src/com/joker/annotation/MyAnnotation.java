package com.joker.annotation;

import com.joker.TestEnum.Gender;

/**
 * 创建一个注解类型
 */
public @interface MyAnnotation {
    //属性，（类似方法）
    String name() default "joker";//属性可以设置默认值，也可以不设置
    int age();
    }

