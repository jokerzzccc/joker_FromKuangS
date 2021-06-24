package com.joker.java8New;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

/**
 * Instant 时间戳
 * ZoneId 时区
 * Date , Instant , LocalDateTime 的转换
 */
public class Demo08 {
    public static void main(String[] args) {
        //1 创建 Instant
        Instant instant = Instant.now();
//        Instant.ofEpochMilli();//也可以用给毫秒数来创建
        System.out.println(instant.toString());//打印的是格林尼治时区的时间
        System.out.println(instant.toEpochMilli());//打印1970到现在的毫秒数
        //2 添加减少时间
        Instant instant1 = instant.plusSeconds(10);
        //打印时间差Duration.between().to--()
        System.out.println(Duration.between(instant,instant1).toMillis());

        //3 ZoneId
//        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();//所有的时区
//        availableZoneIds.forEach(System.out::println);
        System.out.println(ZoneId.systemDefault().toString());//当前时区
        //4 Date , Instant , LocalDateTime 的转换
        System.out.println("===============");
        //4.1   Date--->Instant--->LocalDateTime

        Date date = new Date();
        Instant instant2 = date.toInstant();
        System.out.println(instant2);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
        System.out.println(localDateTime);

        //4.2 LocalDateTime--->Instant--->Date
        System.out.println("========");
        Instant instant3 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant3 );
        Date from = Date.from(instant3);
        System.out.println(from);




    }
}
