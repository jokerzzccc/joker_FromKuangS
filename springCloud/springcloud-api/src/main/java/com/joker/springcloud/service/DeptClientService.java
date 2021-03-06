package com.joker.springcloud.service;

import com.joker.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "http://SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping("/dept/get/{id}")
   public Dept queryById(@PathVariable("id") Long id);
    @GetMapping("/dept/list")
   public List<Dept> queryAll();
    @PostMapping("/dept/add")
   public boolean addDept(Dept dept);
}
