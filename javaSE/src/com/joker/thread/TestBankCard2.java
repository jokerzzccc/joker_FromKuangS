package com.joker.thread;

/**
 * 线程通信
 *
 */
public class TestBankCard2 {
    public static void main(String[] args) {
        //创建银行卡
        BankCard2 bankCard2 = new BankCard2();

        AddMoney2 addMoney2 = new AddMoney2(bankCard2);
        SubMoney2 subMoney2 = new SubMoney2(bankCard2);

        new Thread(addMoney2,"哥哥").start();
        new Thread(subMoney2,"妹妹").start();
        new Thread(addMoney2,"male").start();
        new Thread(subMoney2,"female").start();


    }
}
