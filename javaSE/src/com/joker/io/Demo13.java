package com.joker.io;

import java.io.PrintWriter;

/**
 * PrintWriter 的使用
 *
 * @author joker_chen
 */
public class Demo13 {
    public static void main(String[] args) throws Exception{
        //创建
        PrintWriter pw = new PrintWriter("D:\\2021java学习文件\\mdFile\\pw.txt");
        //打印
        pw.println(97);//打印的是什么样，文件里就是什么样
        pw.println(true);
        pw.println(3.14);
        pw.println('a');

        pw.close();
        System.out.println("over");

    }
}
