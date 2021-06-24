package com.joker.designPatternSingleton;

/**
 * 懒汉式单例
 *  * 1. 首先创建一个对象，赋值为 null
 *  * 2. 构造方法改成私有的，类外部不能创建对象
 *  * 3. 通过一个公开的方法，返回这个对象
 *  加同步的方式有两种:
 *  1. 直接在方法上加锁     public static synchronized Singleton2 getInstance()
 *  2. 用同步代码块
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2(){}
    public static  Singleton2 getInstance(){
        if (instance == null){//这个if 是为了提高执行效率，不必每个线程进来都判断锁
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
