package com.joker.demo01;
//代理，中介
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        viewHouse();
        host.rent();
        signContract();
        takeFee();
    }
    //看房
    public void  viewHouse(){
        System.out.println("中介带你看房");
    }
    //收中介费
    public void  takeFee(){
        System.out.println("收中介费");
    }
    //签合同
    public void  signContract(){
        System.out.println("签合同");
    }
}
