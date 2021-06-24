
package com.joker.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class JokerRandomRule extends AbstractLoadBalancerRule {
// 自定义规则：每个服务访问5次，换下一个服务（这里只有3个）
//自定义两个变量
    //total = 0 ,默认=0，  如果=5 ，指向下一个服务节点
    //index = 0,默认 = 0，如果total = 5 ,index + 1
    private static int total=0;//当前服务被调用的次数
    private static int currentIndex=0;//当前是谁在提供服务

    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//获得活着的服务
            List<Server> allList = lb.getAllServers();//获得全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
//原本的算法
//            int index = chooseRandomInt(serverCount);//生成区间随机数
//            server = upList.get(index);//从活着的服务中 随机获取一个
            //自定义部分
            //====================
            if(total<5){
                server = upList.get(currentIndex);
                total++;
            } else {
                total=0;
                currentIndex++;
                if (currentIndex > upList.size()){
                    currentIndex=0;
                }
                server = upList.get(currentIndex);//从活着的服务，获取指定的服务来进行操作
            }

            //=======================

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}
