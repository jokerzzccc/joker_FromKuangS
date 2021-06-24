package com.joker.java8New;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo01 {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println("hello");
        };

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
//
//        Runnable;
//        Consumer;
//        Supplier;


    }
}
