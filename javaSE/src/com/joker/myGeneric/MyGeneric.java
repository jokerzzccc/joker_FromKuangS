package com.joker.myGeneric;

/**
 * 泛型类
 * 语法：类名<T,...>
 *     T是类型占位符，表示一种引用类型，如果编写多个，用，号隔开
 */
public class MyGeneric<T> {
    //泛型的使用
    //1创建泛型变量
//    不能使用new来创建对象，因为泛型是不确定的类型，构造方法可能是私有
    T t;

    //2泛型作为方法的参数
    public void show(T t){
        System.out.println(t);
    }
//    3泛型作为方法的返回值
    public T getT(){
            return t;
    }
}
