package com.joker.classused;

import java.util.Calendar;
import java.util.Date;

public class Demo08 {
    public static void main(String[] args) {
        //创建Calendar对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());


        //获取时间信息
        int year = calendar.get(calendar.YEAR);//年
        int month = calendar.get(calendar.MONTH);//月取值是0-11，所以输出要加1
        int day = calendar.get(calendar.DAY_OF_MONTH);//日
        int hour = calendar.get(calendar.HOUR_OF_DAY);//时
        int minute = calendar.get(calendar.MINUTE);//分
        int second = calendar.get(calendar.SECOND);//秒
        System.out.println(year);
        System.out.println(month
        );
        System.out.println(year+"|"+(month+1) +"|" +day+"|"+hour+"|"+minute+"|"+second);

        //修改时间
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH,4);
        System.out.println(calendar1.getTime());
        //
        //add()方法修改时间
        calendar1.add(Calendar.HOUR,1);
        System.out.println(calendar1.getTime());
        //补充，去得最大值最小值，比如，当月多少天
        int max = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
        int min = calendar1.getActualMinimum(Calendar.DAY_OF_MONTH);
        System.out.println(max+"\n"+min);





    }
}
