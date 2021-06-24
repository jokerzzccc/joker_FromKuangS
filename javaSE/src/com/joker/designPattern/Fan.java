package com.joker.designPattern;

/**
 * Usb 接口实现类，风扇 Fan
 */
public class Fan implements Usb{
    @Override
    public void service() {
        System.out.println("风扇--开始工作");
    }
}
