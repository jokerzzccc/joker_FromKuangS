package com.joker.thread;

/**
 * 线程案例：四个窗口共卖100张票
 */
public class testTickets {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket,"窗口1").start();
        new Thread(ticket,"窗口2").start();
        new Thread(ticket,"窗口3").start();
        new Thread(ticket,"窗口4").start();
    }
}
