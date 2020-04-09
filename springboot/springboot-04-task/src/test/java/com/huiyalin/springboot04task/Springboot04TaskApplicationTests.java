package com.huiyalin.springboot04task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚吃饭");
        message.setText("今晚7.30约不约？");
        message.setTo("297093122@qq.com");
        message.setFrom("1404225646@qq.com");
        mailSender.send(message);

    }
    @Test
    void test02() throws MessagingException {
        //1、创建一个复杂的邮件
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        //邮件设置
        helper.setSubject("通知-今晚吃饭");
        helper.setText("<b style='color:red'>今晚7.30约不约？</b>",true);
        helper.setTo("hyl19980525@163.com");
        helper.setFrom("1404225646@qq.com");
        helper.addAttachment("111.jpg",new File("E:\\美图\\美城\\111.jpg"));
        mailSender.send(mimeMessage);
    }

}
