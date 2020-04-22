package com.huiyalin.service.impl;

import com.huiyalin.dao.AccountDao;
import com.huiyalin.domain.Account;
import com.huiyalin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String sourceName, String targetName, Float money) {


        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account targetSource = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户价钱
        targetSource.setMoney(targetSource.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        //int i=1/0;
        accountDao.updateAccount(targetSource);
    }

        public Account findAccountById (Integer accountId){

            return accountDao.findAccountById(accountId);

        }
    }
