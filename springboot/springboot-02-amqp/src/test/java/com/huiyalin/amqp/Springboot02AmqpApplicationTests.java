package com.huiyalin.amqp;

import com.huiyalin.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    public void creatExchange(){
        //amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //System.out.println("创建完成");
        //创建队列
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //System.out.println("创建完成");
        //绑定队列与交换机
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","ampq.hh",null));
    }

    /**
     * 1、单播(点对点)
     */
    @Test
    void contextLoads() {
        //Message需要自己构造一个：定义消息体内容和消息头
        //rabbitTemplate.send(exchang,routeKey,message);

        //object默认当成消息体，只需要传入发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object>map=new HashMap<>();
        map.put("msg","这是一个消息");
        map.put("data", Arrays.asList("helloworld,123,true"));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","huiyalin.news",new Book("三国演义","施耐庵"));
    }
    //接收数据如何将数据自动的转化为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("huiyalin.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    /**
     * 广播
     */
    @Test
    public void sendMSG(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("水浒传","施耐庵"));
    }
}
