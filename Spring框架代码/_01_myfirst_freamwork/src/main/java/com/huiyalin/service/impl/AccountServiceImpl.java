package com.huiyalin.service.impl;

import com.huiyalin.bean.BeanFactory;
import com.huiyalin.dao.AccountDao;
import com.huiyalin.dao.impl.AccountDaoImpl;
import com.huiyalin.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao=(AccountDao)BeanFactory.getBean("accountDao");
    //private AccountDao accountDao=new AccountDaoImpl();
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
