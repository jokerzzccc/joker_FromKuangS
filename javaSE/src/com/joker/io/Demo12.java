package com.joker.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * BufferedWriter的使用
 * @author joker_chen
 */
public class Demo12 {
    public static void main(String[] args) throws Exception{
        //创建
        FileWriter fw = new FileWriter("D:\\2021java学习文件\\mdFile\\bw.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        //写入
        for (int i = 0; i < 10; i++) {
            bw.write("好好学习，天天向上");
            bw.newLine();//写入一个换行符
            bw.flush();
        }

        bw.close();
    }
}
