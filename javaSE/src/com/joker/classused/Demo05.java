package com.joker.classused;

/**
 * 需求：
 * String str = "this is a text";
 * 将str中的单词单独获取出来
 * 将str中的text替换为practice
 * 在text钱插入一个easy
 * 将每个单词的 首字母改为大写
 */
public class Demo05 {
    public static void main(String[] args) {
        String str = "this is a text";

        String[] arr = str.split(" ");
        for (String string:arr
             ) {
            System.out.println(string);
        }

        System.out.println("============================");

        System.out.println(str.replace("text","practice"));

        System.out.println("=======================");

        System.out.println(str.replace("text","easy text"));

        System.out.println("=======================");

        for (int i = 0; i < arr.length;i++){
            char first = arr[i].charAt(0);

            char upperFirst = Character.toUpperCase(first);
            String newStr  = upperFirst + arr[i].substring(1);
            System.out.println(newStr);
        }





    }


}
