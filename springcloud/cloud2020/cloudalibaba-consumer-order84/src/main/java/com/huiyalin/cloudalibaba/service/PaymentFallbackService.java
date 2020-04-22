package com.huiyalin.cloudalibaba.service;

import com.huiyalin.springcloud.eneities.CommonResult;
import com.huiyalin.springcloud.eneities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> commonResult(Long id) {
        return new CommonResult<>(444,"降级放回------》PaymentFallBack",new Payment(1L,"null"));
    }
}
