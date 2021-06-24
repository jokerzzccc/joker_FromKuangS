package com.joker.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service//放到容器中
public class UserService {
    //想拿到provider-server提供的票，要去注册中心拿到服务
    @DubboReference//远程应用指定的服务，它会完全按照全类名进行匹配，看谁给注册中心注册了这个全类名，com.joker.service.TicketService
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到了"+ticket);
    }
}
