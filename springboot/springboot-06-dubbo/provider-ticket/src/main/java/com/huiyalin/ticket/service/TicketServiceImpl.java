package com.huiyalin.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.huiyalin.ticket.service.TicketService;
import org.springframework.stereotype.Component;

@Component
@Service//将服务发布出去也就是发布到注册中心去
@EnableDubbo
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "我和我的祖国";
    }
}
