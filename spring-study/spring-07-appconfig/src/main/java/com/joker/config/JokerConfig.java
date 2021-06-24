package com.joker.config;

import com.joker.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//@Configuration 代表这是一个配置类，和之前的beans.xml文件一样
@Configuration//这个也会注册到容器中，它本来就是一个@Component
@ComponentScan("com.joker.pojo")
@Import(JokerConfig2.class)
public class JokerConfig {
    //注册一个bean，相当于bean标签
    //  这个方法的名字，就相当于id属性
    //方法的放回置，就相当于class属性
    @Bean
    public User getUser(){
        return new User();//就是返回要注入到bean的对象
    }

}
