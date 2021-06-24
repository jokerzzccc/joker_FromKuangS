package com.joker.thread;
/**
 * 案例：存钱，取钱，使用匿名内部类
 *
 * @author joker_chen
 */
public class TestBankCard{
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        //创建存钱
        Runnable addMoney = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (bankCard){
                        bankCard.setMoney(bankCard.getMoney() + 1000);
                        System.out.println(Thread.currentThread().getName() + "存了1000,余额是： " + bankCard.getMoney()  );
                    }

                }
            }
        };

        //创建取钱
        Runnable subMoney = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (bankCard){
                        if (bankCard.getMoney() >= 1000){
                            bankCard.setMoney(bankCard.getMoney() - 1000);
                            System.out.println(Thread.currentThread().getName() + "取了1000，余额是：" + bankCard.getMoney());
                        } else {
                            System.out.println("余额不足");
                            i--;//保证可以取完，不会i到了10，还没取出钱
                        }
                    }
                }
            }
        };

        //创建线程对象
        Thread brother = new Thread(addMoney,"哥哥");
        Thread sister = new Thread(subMoney,"妹妹");

        brother.start();
        sister.start();
        brother.getState();
    }
}
