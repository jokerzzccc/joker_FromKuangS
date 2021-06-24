package com.joker.myGeneric;

/**
 * 泛型接口
 * 语法： 接口名<T>
 * 注意： 不能泛型静态常量，因为不知道T是什么类型，即：T t = new T();
 */
public interface GenericInterface<T> {
    String name = "chen";

    T server(T t);

}
