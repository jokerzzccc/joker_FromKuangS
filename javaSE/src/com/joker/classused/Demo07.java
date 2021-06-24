package com.joker.classused;
//验证Stringbuilder效率高于StringBuffer

public class Demo07 {
    public static void main(String[] args) {
        long startT = System.currentTimeMillis();
        StringBuilder str = new StringBuilder();
        for (int i = 0;i < 99999;i++){
            str.append(i);
        }

        long endT = System.currentTimeMillis();
        System.out.println("timeused: "+ (endT - startT));
    }
}
