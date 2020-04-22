package com.huiyalin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication来标注一个主程序类，说明这是一个主程序类
 */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        //Spring应用启动起来
        SpringApplication.run(HelloWorldApplication.class,args);
    }

}
