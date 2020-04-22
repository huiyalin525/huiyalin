package com.huiyalin.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String servePort;
    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "springCloud with Consul"+servePort+"\t"+ UUID.randomUUID().toString();
    }

}
