package com.huiyalin.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了连接工厂ConnectionFactory；
 * 3、RabbitProperties 封装了 RabbitMQ的配置
 * 4、 RabbitTemplate 给RabbitMQ发送消息和接收消息
 * 5、 AmqpAdmin RabbitMQ系统管理功能组件
 * 5、 AmqpAdmin 创建和删除 Queue，Exchange，Binging
 * 6.@RabbitListener+@EnableRabbit 监听消息队列的内容
 */
@EnableRabbit//开启基于注解的RabbitMQ
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
