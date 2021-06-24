package com.joker.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ReentrantLock
 * 用四个线程卖票，
 */
public class TestTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executorService.submit(ticket);

        }
        executorService.shutdown();
    }
}
