package com.huiyalin.springcloud.service;

import com.huiyalin.springcloud.eneities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
