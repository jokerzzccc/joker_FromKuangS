package com.joker;

import redis.clients.jedis.Jedis;

/**
 * Jedis基本连接操作
 */
public class TestPassword {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.117.128.238", 6379);
        //验证reids配置文件的 requirepass 密码，如果没有设置密码这段代码省略
        jedis.auth("123456");
        jedis.connect();//连接
        jedis.disconnect(); //断开连接
        jedis.flushAll(); //清空所有的key
    }
}
