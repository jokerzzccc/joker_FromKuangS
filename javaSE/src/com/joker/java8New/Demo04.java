package com.joker.java8New;

import java.util.ArrayList;

/**
 * Stream的使用 中间操作
 * filter 过滤,limit 限制（元素个数）,skip 跳过,distinct（去重）, sorted 排序
 * map 把数据映射成另外一组数据
 * parallel 获取一个并行流，采用多线程，效率高
 */
public class Demo04 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",1000));
        list.add(new Employee("李四",2000));
        list.add(new Employee("王五",300));
        list.add(new Employee("孙子",4000));
        list.add(new Employee("荀子",5000));
        list.add(new Employee("荀子",5000));

        //1 filter
        list.stream()
                .filter(e->e.getMoney() > 3000)
                .forEach(System.out::println);
        //2 limit
        System.out.println("===============");
        list.stream()
                .limit(2)
                .forEach(System.out::println);
        //3 skip
        System.out.println("===============");
        list.stream()
                .skip(3)
                .forEach(System.out::println);
        //4 distinct 需要重写hashCode()和equals()
        System.out.println("==================");
        list.stream()
                .distinct()
                .forEach(System.out::println);
        //5 sorted
        System.out.println("==================");
        list.stream()
                .sorted((o1, o2) -> Double.compare(o1.getMoney(), o2.getMoney()))//按照工资排序
                .forEach(System.out::println);
        //6 map 把数据映射成另外一组数据
        list.stream()
                .map(employee -> employee.getName())
                .forEach(System.out::println);
        //7 parallel 获取一个并行流，采用多线程，效率高
        list.parallelStream()
                .forEach(System.out::println);
    }
}
