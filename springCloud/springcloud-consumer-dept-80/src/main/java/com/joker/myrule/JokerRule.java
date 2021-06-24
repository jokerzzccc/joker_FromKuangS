package com.joker.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class JokerRule {
    //体验随机算法
    @Bean
    public IRule myRule(){
        return new JokerRandomRule();
    }
}
