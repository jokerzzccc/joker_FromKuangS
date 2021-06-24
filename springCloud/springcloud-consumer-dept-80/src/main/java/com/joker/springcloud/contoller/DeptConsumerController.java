package com.joker.springcloud.contoller;

import com.joker.myrule.JokerRule;
import com.joker.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = JokerRule.class)
public class DeptConsumerController {
    //理解：消费者，不应该有service层，所以，要用Restful风格去请求
    //RestTemplate : springboot的自带的模板，供我们直接调用，注册到spring中，就要去建一个config类
    //三个参数:url，实体：(如果多个可以用放在map里），Class<T> responseType
    //说到底，RestTemplate 就是提供多种便捷访问远程http服务的方法，简单的Restful风格的服务模板
    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX="http://localhost:8001";
//通过Ribbon 实现时，我们这里的地址应该时一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    //要去请求：http://localhost:8001/dept/list
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //因为服务端用的get，这里也只能用get方式
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
