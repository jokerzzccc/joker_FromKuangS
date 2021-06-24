package com.joker.myGeneric;
//创建类时确定接口类型，比如String
public class InterfaceTest1 implements GenericInterface<String>{

    @Override
    public String server(String s) {
        System.out.println(s);
        return s;
    }
}
