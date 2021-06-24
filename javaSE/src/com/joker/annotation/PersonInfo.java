package com.joker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//元注解，
//@Target(ElementType.TYPE)
    public @interface PersonInfo {
    String name();
    int age();
    String sex();
}
