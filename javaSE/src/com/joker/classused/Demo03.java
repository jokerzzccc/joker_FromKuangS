package com.joker.classused;

import java.util.Arrays;

public class Demo03 {
    public static void main(String[] args) {
        String name1 = "hello";//“hello"常量存储在字符串池当中
        name1 = "zhangsan";//"zhangsan"赋值给name变量，并没有修改数据，而是重新开辟一个空间，
        String name2 = "zhangsan";//共享name1在字符串池中的zhangsan

        String content1 = "java is the best programming ,language";
        System.out.println(Arrays.toString(content1.toCharArray()) );

        String[] arr = content1.split("[ ,]+");
        for (String string:arr
             ) {
            System.out.println(string);
        }

        //equals()
        String str1 = "hello";
        String str2 = "HELLO";
        System.out.println(str1.equalsIgnoreCase(str2));
        //comparTo()
        String str3 = "abc";
        String str4 = "axhkd";//依次往后只直到有不同的值，比较那一个对应的大小
        System.out.println(str3.compareTo(str4));
        String str5 = "abcdef";//若前面都相同，则比较长度
        System.out.println(str3.compareTo(str5));


    }
}
