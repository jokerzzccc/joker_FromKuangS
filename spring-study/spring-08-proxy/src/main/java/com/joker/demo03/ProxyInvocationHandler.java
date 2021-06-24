package com.joker.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Rent rent;
    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    //除了rent，都是固定的
    public Object getProxy(){
      return   Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }
    @Override//处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        viewHouse();
        //动态代理的本质，就是使用反射机制实现
        Object result = method.invoke(rent, args);
        takeFare();
        return result;
    }
    public void viewHouse(){
        System.out.println("中介带看房");
    }
    public void takeFare(){
        System.out.println("收中介费");
    }
}
