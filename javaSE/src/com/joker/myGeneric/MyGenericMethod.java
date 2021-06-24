package com.joker.myGeneric;

/**
 * 泛型方法
 * 语法：<T> 返回值类型 方法名
 */
public class MyGenericMethod {
    //
    public <T> void show(T t){
        System.out.println("泛型方法" + t);
    }
}

