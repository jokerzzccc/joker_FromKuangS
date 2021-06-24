package com.joker.classused;

public class Demo06 {
    public static void main(String[] args) {
        StringBuffer strb = new StringBuffer();

        //apend()追加
        strb.append("java");
        System.out.println(strb.toString());
        strb.append("python");
        System.out.println(strb.toString());

        //insert() 添加，可以在某个位置添加,各种类型的数据
        strb.insert(0,"Head");
        System.out.println(strb);

        //replace() 替换,注意尾标，含头不含尾
        strb.replace(0,4,"rep");
        System.out.println(strb.toString());

        //delete() 删除
        strb.delete(0,3);
        System.out.println(strb.toString());
        strb.deleteCharAt(2);
        System.out.println(strb.toString());
        //清空
        System.out.println(strb.delete(0,strb.length()).toString() +"qingkong");

    }
}
