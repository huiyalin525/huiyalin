package com.huiyalin.test;

import com.huiyalin.domain.Account;
import com.huiyalin.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 *      1.应用程序的入口
 *              main方法
 *      2.junit单元测试方法中，没有main方法也能执行
 *              junit集成了一个main方法
 *              该方法就会判断当前测试类中哪些方法有@Test注解
 *              junit就让有Test注解的方法执行
 *      3.junit不会管我们是否采用spring框架
 *              在执行测试方法时，junit根本不知道我们是不是使用了spring框架
 *              所以也就不会为我们读取配置文件/配置类创建spring核心容器
 *      4.有以上三点可知
 *              当测试方法执行时没有Ioc容器，就算写了Autowired注解，也无法实现注入
 *
 *     所以在这里我们就提供一个可以为测试方法提供main方法的jar包spring-test
 *     spring整合junit的配置
 *            1.导入spring整合junit的jar(或坐标)
 *            2.使用junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *              @Runwith
 *            3.告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *              @ContextConfiguration
 *                      locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                      classes:指定注解类所在的位置
 *    当我们在使用spring5.0的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private AccountService as;

    @Test
    public void testFindAll(){
        //1.获取容器
        //ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        //AccountService accountService=ac.getBean("accountService", AccountService.class);
        //3.执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //1.获取容器
        //ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        //AccountService accountService=ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account=as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account=new Account();
        account.setName("武汉加油a");
        account.setMoney(100000000000.0);
        //1.获取容器
        //ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);;
        //2.得到业务层对象
        //AccountService accountService=ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){

        //1.获取容器
        //ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        //AccountService accountService=ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account =as.findAccountById(4);
        account.setMoney(100000.0);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //1.获取容器
        //ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        //AccountService accountService=ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.deleteByAccountId(3);
    }
}
