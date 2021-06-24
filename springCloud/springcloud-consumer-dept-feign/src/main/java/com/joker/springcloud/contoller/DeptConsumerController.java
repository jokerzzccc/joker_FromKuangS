package com.joker.springcloud.contoller;

import com.joker.springcloud.pojo.Dept;
import com.joker.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Qualifier("com.joker.springcloud.service.DeptClientService")
    @Autowired
    private DeptClientService service=null;

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return this.service.addDept(dept);
    }

    //要去请求：http://localhost:8001/dept/list
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.service.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return this.service.queryAll();
    }

}
