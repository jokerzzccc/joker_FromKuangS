package com.joker.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService//可以被扫描到，在项目一启动就注册到注册中心
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "joker";
    }
}
