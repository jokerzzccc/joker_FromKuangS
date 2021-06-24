package com.joker.myGeneric;

public class TestGeneric {
    public static void main(String[] args) {
        //使用泛型类型创建对象
        //1 泛型类型只能是引用类型
//        2.不同泛型类型对象之间不能相互赋值
//        比如：MyGeneric<String> myGeneric3 = integerMyGeneric;
        MyGeneric<String> stringMyGeneric = new MyGeneric<>();
        stringMyGeneric.t = "hello";
        stringMyGeneric.show("generic_test");
        String str = stringMyGeneric.getT();
        System.out.println(stringMyGeneric.t +"-"+ str);

        MyGeneric<Integer> integerMyGeneric = new MyGeneric<>();
        integerMyGeneric.t = 10;
        integerMyGeneric.show(200);
        Integer int_ge = integerMyGeneric.getT();
        System.out.println(integerMyGeneric.t + "-" + int_ge);

        InterfaceTest1 interfaceTest1 = new InterfaceTest1();
        interfaceTest1.server("hello");

        InterfaceTest2<Integer> test2 = new InterfaceTest2<>();
        test2.server(1000);

        //泛型方法
        MyGenericMethod myGenericMethod = new MyGenericMethod();
        myGenericMethod.show("fanxing");//t的类型由show里面的数据直接决定
        myGenericMethod.show(200);
        myGenericMethod.show(3.33);



    }
}
