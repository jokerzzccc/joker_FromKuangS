package com.joker.classused;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimal {
    public static void main(String[] args) {
        double d1 = 1.0;
        double d2 = 0.9;
        System.out.println(d1 - d2);

        //bigdecimal类
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("0.9");
        //subtract减法
        System.out.println(bd1.subtract(bd2));
        BigDecimal bd3 = new BigDecimal("10").divide(new BigDecimal("3"),3,RoundingMode.HALF_UP);
        System.out.println(bd3);


    }
}
