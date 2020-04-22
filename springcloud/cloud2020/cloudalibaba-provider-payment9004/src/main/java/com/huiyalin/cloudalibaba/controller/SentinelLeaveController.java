package com.huiyalin.cloudalibaba.controller;

import com.huiyalin.springcloud.eneities.CommonResult;
import com.huiyalin.springcloud.eneities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SentinelLeaveController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"11111"));
        hashMap.put(2L,new Payment(2L,"22222"));
        hashMap.put(3L,new Payment(3L,"33333"));
    }
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result =new  CommonResult(200,"from mysql serverport"+serverPort,payment);
        return result;
    }
}
