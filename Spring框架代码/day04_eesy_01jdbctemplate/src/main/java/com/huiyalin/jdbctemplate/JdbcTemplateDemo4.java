package com.huiyalin.jdbctemplate;

import com.huiyalin.dao.AccountDao;
import com.huiyalin.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountDao accountDao=ac.getBean("accountDao",AccountDao.class);
        //3.执行操作
        Account account=accountDao.findAccountById(1);
        System.out.println(account);

        account.setId(1);
        account.setMoney(2000.0);
        accountDao.updateAccount(account);

    }
}