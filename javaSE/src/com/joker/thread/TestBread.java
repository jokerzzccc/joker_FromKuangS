package com.joker.thread;

/**
 * 生产者消费者
 * 测试列
 *
 */
public class TestBread{
    public static void main(String[] args) {
        BreadContainer breadContainer = new BreadContainer();

        Product product = new Product(breadContainer);
        Consume consume = new Consume(breadContainer);

        new Thread(product,"brother").start();
        new Thread(consume,"sister").start();
        new Thread(product,"dad").start();
        new Thread(consume,"mom").start();


    }
}
