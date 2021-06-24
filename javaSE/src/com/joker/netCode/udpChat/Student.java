package com.joker.netCode.udpChat;

public class Student {
    public static void main(String[] args) {
        //开启两个线程，因为又要接收，又要发送
        new Thread(new SendThread(7777,"localhost",9999)).start();
        new Thread(new ReceiveThread(8888,"老师")).start();
    }

}
