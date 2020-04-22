package com.huiyalincloudalibaba.service.impl;

import com.huiyalincloudalibaba.dao.OrderDao;
import com.huiyalincloudalibaba.domain.Order;
import com.huiyalincloudalibaba.service.AccountService;
import com.huiyalincloudalibaba.service.OrderService;
import com.huiyalincloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    /**
     * 创建订单--->storage微服务扣减库存---->account微服务扣减账户余额--->修改状态
     *
     *
     */
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "default",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //1.新建订单
        log.info("----->开始新建订单");
        orderDao.createOrder(order);
        //2.扣减库存
        log.info("----->订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");
        //3.扣减账户
        log.info("----->订单微服务开始调用库存，做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //4.修改订单的状态从0到1 1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.updateOrderStatus(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("订单结束");
    }
}
