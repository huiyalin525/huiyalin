package com.huiyalin.service.impl;

import com.huiyalin.Dao.AccountDao;
import com.huiyalin.domain.Account;
import com.huiyalin.service.AccountService;
import com.huiyalin.utils.TransactionManager;

import java.util.List;
/*
*   账户的业务实现类
*
*   事务控制应该都在业务层
* */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();

    }

    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);

    }


    public void saveAccount(Account account) {

        accountDao.saveAccount(account);

    }


    public void updateAccount(Account account) {

        accountDao.updateAccount(account);

    }


    public void deleteByAccountId(Integer accountId) {

        accountDao.deleteByAccountId(accountId);


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
//        int i=1/0;
        accountDao.updateAccount(targetSource);


    }
}