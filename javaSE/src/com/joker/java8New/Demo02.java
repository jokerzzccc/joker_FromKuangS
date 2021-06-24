package com.joker.java8New;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常见函数式接口的Lambda 表达式使用
 */
public class Demo02 {
    public static void main(String[] args) {
        //Consumer 消费型接口
        Consumer<Double> consumer = t-> System.out.println("聚会消费:" + t);
        test1(consumer,10000);
//        test1(t-> System.out.println("聚会消费:" + t)，1000);//也可以直接用

        //Supplier 供给型接口
        int[] nums = getNums(() -> new Random().nextInt(100), 5);
        System.out.println(Arrays.toString(nums));

        //Function 函数式接口
        System.out.println(testFunction(s -> s.toUpperCase(),"function"));

        //Predicate 断言式接口(判断)
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1orange1");
        arrayList.add("1purple22");
        arrayList.add("3durian333");
        arrayList.add("watermelon4");

        System.out.println(testPredicate(s -> s.startsWith("1"),arrayList).toString());
        System.out.println(testPredicate(s -> s.length() > 8,arrayList));

    }
    public static void test1(Consumer<Double> consumer,double money){
        consumer.accept(money);
    }

    public static int[] getNums(Supplier<Integer> supplier,int count){
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = supplier.get();
        }

        return arr;

    }

    public static String testFunction(Function<String,String> function,String str){
        return function.apply(str);
    }

    public static List<String> testPredicate(Predicate<String> predicate,ArrayList<String> list){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String string : list) {
            if (predicate.test(string)){
                arrayList.add(string);
            }
        }
        return arrayList;
    }
}
