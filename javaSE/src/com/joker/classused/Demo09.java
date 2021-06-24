package com.joker.classused;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo09 {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//分隔符可以随便用/，：等
        Date date = new Date();//创建Date
        String str = sdf.format(date);//格式化date，把日期转换成字符串
        System.out.println(str);

        //解析，把字符串转换成日期
        //Date date2 = sdf.parse("1990-05-01");
        //System.out.println(date2);



    }
}
