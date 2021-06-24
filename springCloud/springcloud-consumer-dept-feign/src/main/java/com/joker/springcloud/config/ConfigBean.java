package com.joker.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //相当于 spring 的 applicationContext.xml 配置
public class ConfigBean {
    // Ribbon里的核心接口IRule，有很多继承类，实现负载均衡算法规则
    // RoundRobinRule 轮询
    // RandomRule 随机
    // AvailabilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
    // RetryRule ： 会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
    @Bean
    @LoadBalanced//Ribbon :配置负载均衡实现 RestTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
