package com.joker.designPatternSingleton;

/**
 * 多线程来测试饿汉式单例
 * 测试结果三个线程都是拿到了同一个对象
 */
public class TestSingleton {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton3.getInstance().hashCode());//打印地址
                }
            }).start();
        }
    }
}
