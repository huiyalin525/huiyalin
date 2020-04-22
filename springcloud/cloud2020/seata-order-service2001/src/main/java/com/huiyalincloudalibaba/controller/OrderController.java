package com.huiyalincloudalibaba.controller;

import com.huiyalincloudalibaba.domain.CommonResult;
import com.huiyalincloudalibaba.domain.Order;
import com.huiyalincloudalibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
       orderService.createOrder(order);
       return new CommonResult(200,"订单创建成功");
    }

}
