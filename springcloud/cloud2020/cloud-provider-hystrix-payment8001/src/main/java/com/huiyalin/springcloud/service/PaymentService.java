package com.huiyalin.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    String paymentInfo_OK(Integer id);
    String paymentInfo_TimeOut(Integer id);
    String paymentCircuitBreaker_fallback(Integer id);
    String paymentCircuitBreaker(Integer id);
}
