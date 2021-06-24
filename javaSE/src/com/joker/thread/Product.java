package com.joker.thread;

/**
 * 生产者
 */
public class Product implements Runnable
{
        private BreadContainer con;
        public  Product(BreadContainer breadContainer){
            super();
            this.con = breadContainer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                con.input(new Bread(i,Thread.currentThread().getName()));
            }

        }

}
