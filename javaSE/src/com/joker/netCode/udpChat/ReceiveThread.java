package com.joker.netCode.udpChat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveThread implements Runnable {
    DatagramSocket datagramSocket = null;

    private int port;
    private String msgFrom;

    public ReceiveThread(int port,String msgFrom) {
        this.port = port;
        this.msgFrom  = msgFrom;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true){
            try {
                //准备接受包裹
                byte[] container = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(container,0,container.length);
                datagramSocket.receive(datagramPacket);//阻塞式接受包裹

                //断开连接 bye
                byte[] data = datagramPacket.getData();
                String receiveData = new String(data, 0, data.length);

                System.out.println(msgFrom+ ":"+receiveData);

                if (receiveData.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}
