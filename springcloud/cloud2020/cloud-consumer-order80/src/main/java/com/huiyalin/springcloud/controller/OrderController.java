package com.huiyalin.springcloud.controller;

import com.huiyalin.springcloud.eneities.CommonResult;
import com.huiyalin.springcloud.eneities.Payment;
import com.huiyalin.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";这个写死在里面
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    public DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //返回对象为响应体中数据转化成的对象，基本上可以理解我json
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);//实际调用的是post
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id")Long id){
        //返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonResult<Payment>(444,"操作失败");
        }
    }
    @GetMapping("/consumer/payment/createForEntity")
    public CommonResult<Payment> create2(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);//实际调用的是post
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("Cloud-Payment-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }else {
            ServiceInstance serviceInstance = loadBalancer.instance(instances);
            URI uri = serviceInstance.getUri();

            return restTemplate.getForObject(uri+"/payment/lb",String.class);
        }

    }
    //------->sleuth+zipkin
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result=restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin",String.class);
        return result;
    }
}
