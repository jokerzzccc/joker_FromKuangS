package com.joker.netCode.udpChat;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new SendThread(5555,"localhost",8888) ).start();
        new Thread(new ReceiveThread(9999,"学生")).start();
    }
}
