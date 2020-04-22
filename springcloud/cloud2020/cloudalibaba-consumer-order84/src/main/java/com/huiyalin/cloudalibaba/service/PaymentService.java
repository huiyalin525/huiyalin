package com.huiyalin.cloudalibaba.service;

import com.huiyalin.springcloud.eneities.CommonResult;
import com.huiyalin.springcloud.eneities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
//先查找Nacos上的服务名称查找到以后发送对应的请求fallback是出错以后兜底的方法比如说关掉服务器
public interface PaymentService {

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> commonResult(@PathVariable("id") Long id);

}
