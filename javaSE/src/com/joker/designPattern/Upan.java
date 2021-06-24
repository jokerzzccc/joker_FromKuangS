package com.joker.designPattern;

/**
 * Usb 接口实现类 U盘 Upand
 */
public class Upan implements Usb{
    @Override
    public void service() {
        System.out.println("u盘---开始工作");
    }
}
