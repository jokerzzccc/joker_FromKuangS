package com.joker.designPatternSingleton;

/**
 * 单例第三种写法：静态内部类写法
 */
public class Singleton3 {
    private Singleton3(){};
    public static class Holder{//静态内部类，在不使用的时候，不会执行
        static Singleton3 instance = new Singleton3();//使用new 本身就是线程安全的
    }
    public static Singleton3 getInstance(){
        return Holder.instance;
    }
}
