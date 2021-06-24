package com.joker.designPattern;

/**
 * 工厂类
 * 负责产品的具体创建工作
 */
public class UsbFactory {
    public static Usb creatUsb(String type) throws ClassNotFoundException {//type 优化后表示产品类型的全名称 com.joker...
        Usb usb = null;
//        if (type == 1) {//1表示鼠标
//            usb = new Mouse();
//        } else if(type == 2){//2表示风扇
//            usb = new Fan();
//        }else if (type == 3){//3表示U盘
//            usb = new Upan();
//        }
        //反射优化之后
        Class<?> class1 = Class.forName(type);
        try {
            usb =(Usb) class1.newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return usb;
    }
}
