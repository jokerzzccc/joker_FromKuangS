package com.joker.java8New;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用 的使用
 * 只要引用方法的特征和接口的特点是一样的，就可以用，
 * - 1 对象::实例方法
 * - 2 类::静态方法
 * - 3 类::实例方法
 * - 4 类::new
 */
public class Demo03 {
    public static void main(String[] args) {
        //1 对象::实例方法
        //比如 println()也是带参无返回值型，Consumer接口的accept()也是带参无返回值型
        //普通lambda
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello");
        //方法引用
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("java");

        // 2 类::静态方法
        Comparator<Integer> comparator = (o1,o2)->Integer.compare(o1,o2);
        Comparator<Integer> comparator1 = Integer::compare;

        //3 类::实例方法,自己构造的类 Employee
        Function<Employee,String> function = e->e.getName();
        Function<Employee,String> function1 = Employee::getName;
        System.out.println(function1.apply(new Employee("apple")));

        //4 类::new
        Supplier<Employee> supplier = ()->new Employee();
        Supplier<Employee> supplier1 = Employee::new;
        Employee employee = supplier1.get();
        System.out.println(employee.toString());

    }
}
