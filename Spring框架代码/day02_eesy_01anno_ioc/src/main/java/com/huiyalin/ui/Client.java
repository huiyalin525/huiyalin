package com.huiyalin.ui;


import com.huiyalin.dao.AccountDao;
import com.huiyalin.service.AccountService;
import com.huiyalin.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client  {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     *
     *
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
        //ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountService as=(AccountService)ac.getBean("accountServiceImpl");

        System.out.println(as);
/*        AccountDao ad=(AccountDao)ac.getBean("accountDao");
        System.out.println(ad);*/
        as.saveAccount();
        ac.close();
    }
}
