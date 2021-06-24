package com.joker.thread;

/**
 * 线程通信
 */
public class AddMoney2 implements Runnable{
    private BankCard2 card2;

    public AddMoney2(BankCard2 card2) {
        this.card2 = card2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            card2.sale(1000);
        }
    }
}
