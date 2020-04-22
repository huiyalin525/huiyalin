package com.huiyalin.ui;

import com.huiyalin.bean.BeanFactory;
import com.huiyalin.service.AccountService;
import com.huiyalin.service.impl.AccountServiceImpl;

public class Client  {
    public static void main(String[] args) {
        AccountService accountService= (AccountService) BeanFactory.getBean("accountService");
        //AccountService accountService=new AccountServiceImpl();
        accountService.saveAccount();
    }
}
