package com.joker.netCode;

/**
 * 案例4 使用 Socket 实现注册登录
 */
public class UserServer {
    public static void main(String[] args) {
        new RegistThread().start();
        new LoginThread().start();
    }
}
