package com.joker.reflection;

/**
 * 获取 类加载器
 */
public class Test2 {
    public static void main(String[] args) {
        //获得系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(
                systemClassLoader
        );
        //获得系统类加载器的父类，扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获得扩展类加载器的父类，根加载器（c/c++编写）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }
}
