package com.joker.io;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 转换流 InputSteamReader 的使用，可以指定使用的编码
 * @author joker_chen
 *
 */
public class Demo14 {
    public static void main(String[] args) throws Exception {
        //创建
        FileInputStream fis = new FileInputStream("D:\\2021java学习文件\\mdFile\\pw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        //读取
        int data = 0;
        while ((data = isr.read()) != -1){
            System.out.print((char) data);
        }

        isr.close();

    }
}
