package com.joker.designPatternSingleton;

/**
 * 饿汉式单例
 * 1. 首先创建一个常量
 * 2. 构造方法改成私有的，类外部不能创建对象
 * 3. 通过一个公开的方法，返回这个对象
 */
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
