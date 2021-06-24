package com.joker.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //cron表达式
    //秒，分 时 日 月 周几
    @Scheduled(cron = "48 48 15 * * ?")//在一个特定的时间执行
    public void hello(){
        System.out.println("执行了");
    }
}
