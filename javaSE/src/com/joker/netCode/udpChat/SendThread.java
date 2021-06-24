package com.joker.netCode.udpChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SendThread implements Runnable{
    DatagramSocket datagramSocket = null;
    BufferedReader bufferedReader = null;

    private String toIP;
    private int fromPort;
    private int toPort;

    public SendThread(int fromPort,String toIP, int toPort) {
        this.toIP = toIP;
        this.fromPort = fromPort;
        this.toPort = toPort;

        try {
            datagramSocket = new DatagramSocket(fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            String data = null;
            try {
                data = bufferedReader.readLine();//因为不可读，所以必须转成字节数据
                byte[] datas = data.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));

                datagramSocket.send(datagramPacket);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        datagramSocket.close();
    }
}

