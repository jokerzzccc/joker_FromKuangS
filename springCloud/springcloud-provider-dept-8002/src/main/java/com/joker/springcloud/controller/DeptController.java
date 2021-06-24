package com.joker.springcloud.controller;

import com.joker.springcloud.pojo.Dept;
import com.joker.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    //得到具体的微服务信息，可以通过源码看见，接口DiscoveryClient  实现类有一个 EurekaDiscoveryClient
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }
    //注册进来的服务，通过服务发现来获取一些相关消息
    @RequestMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery--->services"+services);
        //得到一个具体的微服务信息,通过具体的微服务id,也就是 ApplicationName
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId());
        }
        return this.discoveryClient;
    }
}
