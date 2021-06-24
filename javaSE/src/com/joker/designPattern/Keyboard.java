package com.joker.designPattern;

/**
 * 键盘
 */
public class Keyboard implements Usb{
    @Override
    public void service() {
        System.out.println("键盘 开始工作");
    }
}
