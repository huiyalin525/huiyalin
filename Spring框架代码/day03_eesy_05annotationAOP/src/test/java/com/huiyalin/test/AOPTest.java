package com.huiyalin.test;

import com.huiyalin.service.AccountService;
import com.huiyalin.service.impl.AccountServiceImpl;
import com.huiyalin.utils.Logger;
import com.huiyalin.utils.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)*/ //当使用无xml文件
public class AOPTest {
/*    @Autowired
    private  AccountService as;*/
    @Test
    public  void main() {
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountService as=(AccountService) ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
    }
}
