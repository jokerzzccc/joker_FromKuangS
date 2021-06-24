package com.joker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joker.pojo.User;
import com.joker.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class Redis02SpringbootApplicationTests {
    @Autowired
    @Qualifier("redisTemplate")//这里是为了指定到我们自己的redisTemplate,不然底层还有一个自动配置的
    private RedisTemplate redisTemplate;
    //装配自定义的工具类 RedisUtil
    @Autowired
    private RedisUtil redisUtil;
    //测试工具类的使用
    @Test
    public void testUtil(){
        redisUtil.set("utilKey","joker");
        System.out.println(redisUtil.get("utilKey"));
    }
    @Test
    void contextLoads() {
        //redisTemplate 操作不同的
        //opsForValue 操作字符串，类似String
        //opsForList 操作List，类似List
        //....
        //常用的方法，都可以直接用 redisTemplate 操作，比如事务和基本的增删改查

        //获取redis的连接对象 一般很少用
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("mykey","joker");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test1() throws JsonProcessingException {
        //真实的开发，一般用json来传递对象数据
        User user = new User("joker", 22);
        //ObjectMapper 是jackson 里面的，这里是把对象转换为字符串
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        //如果直接传递一个没有序列化的对象，会直接报错，所以需要把对象序列化
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));


    }

}
