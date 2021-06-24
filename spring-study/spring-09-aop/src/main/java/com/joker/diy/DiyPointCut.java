package com.joker.diy;
//方式二：自定义的一个切面类
public class DiyPointCut {
    public void before(){
        System.out.println("方法执行前前前前=========");
    }
    public void after(){
        System.out.println("方法执行后后后后=========");
    }
}
