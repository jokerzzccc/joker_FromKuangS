package com.joker.designPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * 客户程序
 * 住如果每添加一产品，都需要在 UsbFactory 里添加，很麻烦，所以用反射来优化
 */
public class Demo01 {
    public static void main(String[] args) throws Exception
    {
        System.out.println("----选择购买：1 鼠标 2 风扇 3 U盘----");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        //1 =com.joker.designPattern.Mouse
        //2 =com.joker.designPattern.Fan
        //3 =com.joker.designPattern.Upan
        //4 =com.joker.designPattern.Keyboard
        //创建一个 properties 文件后
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/com/joker/designPattern/usb.properties");
        properties.load(fis);
        fis.close();

        Usb usb = UsbFactory.creatUsb(properties.getProperty(choice));
        if (usb != null ){
            System.out.println("购买成功");
            usb.service();
        }else {
            System.out.println("购买的产品不存在");
        }
    }
}
