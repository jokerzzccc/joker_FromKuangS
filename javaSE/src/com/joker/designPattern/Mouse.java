package com.joker.designPattern;

    /**
     * Usb 接口实现类，即子类产品 鼠标 Mouse
     */
    public class Mouse implements Usb{
        @Override
        public void service() {
            System.out.println("鼠标开始工作");
        }
    }
