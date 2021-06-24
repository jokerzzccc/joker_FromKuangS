package com.joker.io;

import java.io.FileWriter;

/**
 * FileWriter
 * @author joker_chen
 */
public class Demo09 {
    public static void main(String[] args) throws Exception{
        FileWriter fr = new FileWriter("D:\\2021java学习文件\\mdFile\\fw.txt");
        //写入
        for (int i = 0; i < 10; i++) {
            fr.write("java\r");
            fr.flush();
        }

        fr.close();
    }
}
