package com.joker.demo01;
//客户
public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理，中介帮 房东租房子，但是，代理角色一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        //客户不用面对房东，直接找中介
        proxy.rent();
    }
}
