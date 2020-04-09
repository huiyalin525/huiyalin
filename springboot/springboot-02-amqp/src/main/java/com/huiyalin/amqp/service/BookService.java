package com.huiyalin.amqp.service;

import com.huiyalin.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @RabbitListener(queues = "huiyalin.news")
    public void receive(Book book){
       // System.out.println(book);
    }
    @RabbitListener(queues = "huiyalin")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
