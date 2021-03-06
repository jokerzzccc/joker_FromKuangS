package com.joker.springcloud;

import com.joker.myrule.JokerRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//Ribbon 和Eureka 整合以后，客户端可以直接调用服务，不用关心IP 地址和端口号
//启动类
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候，就能去加载我们自定义的Ribbon 类

public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
