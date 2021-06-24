package com.joker;

import redis.clients.jedis.Jedis;

/**
 * 测试jedis 的ping
 */
public class TestPing {
    public static void main(String[] args) {
        //new Jedis 对象即可
        Jedis jedis = new Jedis("47.117.128.238",6379);
        jedis.auth("123456");
        //Jedis 所有的函数，就是redis的所有指令，
        System.out.println(jedis.ping());

    }
}
