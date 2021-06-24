package com.joker.thread;

/**
 * 案例：龟兔赛跑-Race
 * 要求:
 *
 */
public class Race implements Runnable{
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子的休息，就是使用延时
            if (Thread.currentThread().getName().equals("rabbit") && i % 10 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = geamOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i +"步数");
        }
    }

    public static boolean geamOver(int steps){
        if (winner != null){
            return true;
        }
        if (steps == 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"rabbit").start();
        new Thread(race,"turtle").start();
    }
}
