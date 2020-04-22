package com.huiyalin.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentALi9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentALi9001.class,args);
    }

}
