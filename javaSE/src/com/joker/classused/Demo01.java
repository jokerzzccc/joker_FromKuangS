package com.joker.classused;

public class Demo01 {
    public static void main(String[] args) {
        int num = 10;
        //类型转换：装箱，基本类型转换为引用类型
        int num1 = 18;
       String str1 = num + "";
       String str2 = Integer.toString(num,16);

        System.out.println(str1);
        System.out.println(str2);

        String str = "150";
        int num2 = Integer.parseInt(str);
        System.out.println(num2);


        String str3 = "true";
        Boolean b1 = Boolean.parseBoolean(str3);
        System.out.println(b1);



    }
}
