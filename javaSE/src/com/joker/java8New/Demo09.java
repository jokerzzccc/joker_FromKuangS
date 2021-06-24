package com.joker.java8New;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter 的使用
 */
public class Demo09 {
    public static void main(String[] args) {
        //创建DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//创建里of--里可以有很多种，
        //把时间格式化成字符串
        String format = dtf.format(LocalDateTime.now());
        System.out.println(format);
        //把字符串解析成时间
        LocalDateTime parse = LocalDateTime.parse("2021-03-10 10:10:20",dtf);
        System.out.println(parse);
    }
}
