package com.huiyalin.springcloud.controller;

import com.huiyalin.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_Fallback_Method")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;
    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }
    @GetMapping(value = "/consumer/payment/hystrix/TimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int a = 10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String paymentInfo_TimeOutFallback(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒钟后尝试，或者自己云运行出错检查自己，o(╥﹏╥)o";
    }
    //下面是全局fallback方法
    public String payment_Global_Fallback_Method(){
        return "Global全局异常处理信息请稍后再试";
    }
}
