package com.joker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling//开启定时功能的注解
@SpringBootApplication
public class Springboot07TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07TestApplication.class, args);
    }

}
