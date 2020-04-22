package com.huiyalin.springcloud.service;

import org.springframework.stereotype.Component;

//作为实现类目的是写一个兜底的方法来降低程序的耦合性
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall paymentInfo_OK back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService paymentInfo_TimeOut fall back";
    }
}
