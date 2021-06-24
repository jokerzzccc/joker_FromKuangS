package com.joker.java8New;

import java.time.LocalDateTime;

/**
 * 新的时间API
 * LocalDateTime类 的使用
 *
 */
public class Demo07 {
    public static void main(String[] args) {
        //1 创建本地时间
        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime1 = LocalDateTime.of();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMonth());

        //2 添加两天，调用方法都是返回一个新的对象，LocalDateTime 的对象也具有不可变性
        LocalDateTime localDateTime1 = localDateTime.plusDays(2);
        System.out.println(localDateTime1);

        //3 减少
        LocalDateTime localDateTime2 = localDateTime.minusMonths(1);
        System.out.println(localDateTime2);
    }
}
