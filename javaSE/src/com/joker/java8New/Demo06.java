package com.joker.java8New;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Stream 的使用 终止操作
 * forEach , min , max , count , reduce , collect
 *
 */
public class Demo06 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",1000));
        list.add(new Employee("李四",2000));
        list.add(new Employee("王五",300));
        list.add(new Employee("孙子",4000));
        list.add(new Employee("荀子",5000));

        //forEach 遍历，用的最多，
        list.stream()
                .filter(employee -> employee.getMoney() > 3000)
                .forEach(System.out::println);
        //min 最小 max 最大 count(计算数据个数)
        System.out.println("==========");
        Optional<Employee> min = list.stream()//用Optional 是为了解决控制异常问题，比如没找到，或者表达式有问题
                .min(((o1, o2) -> Double.compare(o1.getMoney(), o2.getMoney())));
        System.out.println(min.get());

        System.out.println("==========");
        Optional<Employee> max = list.stream()
                .max(((o1, o2) -> Double.compare(o1.getMoney(), o2.getMoney())));
        System.out.println(max.get());

        long count = list.stream().count();
        System.out.println("员工个数：" + count);
        //reduce 规约
        //计算所有员工的工资和
        Optional<Double> sum = list.stream()
                .map(e -> e.getMoney())
                .reduce((x, y) -> x + y);//reduce里是一个二元操作符，就是两个参数，一个返回值
        System.out.println(sum.get());
        //collection 收集
        //获取所有员工的姓名，封装成一个list 集合
        List<String> collect = list.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
        for (String name : collect) {
            System.out.println(name);
        }
    }
}
