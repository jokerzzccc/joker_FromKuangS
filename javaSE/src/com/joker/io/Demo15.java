package com.joker.io;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * OutputStreamWriter 写入文件，指定编码
 *
 */
public class Demo15 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("D:\\2021java学习文件\\mdFile\\fos.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        //写入
        for (int i = 0; i < 10; i++) {
            osw.write("我是joker\n");
            osw.flush();
        }

        osw.close();

    }
}
