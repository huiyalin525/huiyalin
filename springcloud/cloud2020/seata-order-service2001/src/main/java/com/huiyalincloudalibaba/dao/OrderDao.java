package com.huiyalincloudalibaba.dao;

import com.huiyalincloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;

@Mapper
public interface OrderDao {

    //新建订单
    void createOrder(Order order);

    //修改订单状态，从0改为1
    void updateOrderStatus(@Param("userId")Long userId,@Param("status") Integer status);
}
