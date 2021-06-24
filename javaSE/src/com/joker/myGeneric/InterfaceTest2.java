package com.joker.myGeneric;
//创建类时时不确定接口类型,把实现类(interfaceTest2)当作泛型类
//
public class InterfaceTest2<T> implements GenericInterface<T>{

    @Override
    public T server(T t) {
        System.out.println(t);
        return t;
    }
}
