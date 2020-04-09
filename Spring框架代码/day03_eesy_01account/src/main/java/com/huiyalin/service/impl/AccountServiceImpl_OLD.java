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
public class AccountServiceImpl_OLD implements AccountService {

    private AccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
           List<Account>accounts= accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch(Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account= accountDao.findAccountById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        }catch(Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }
    }


    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果

        }catch(Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }



    public void updateAccount(Account account) {
        try {
        //1.开启事务
        txManager.beginTransaction();
        //2.执行操作accountDao.updateAccount(account);
        //3.提交事务
        txManager.commit();
        //4.返回结果

        }catch(Exception e){
        //5.回滚操作
        txManager.rollback();
        }finally {
        //6.释放连接
        txManager.release();
        }
}



    public void deleteByAccountId(Integer accountId) {
        try {
        //1.开启事务
        txManager.beginTransaction();
        //2.执行操作
        accountDao.deleteByAccountId(accountId);
        //3.提交事务
        txManager.commit();
        }catch(Exception e){
        //4.回滚操作
        txManager.rollback();
        }finally {
        //5.释放连接
        txManager.release();
        }

        }



    public void transfer(String sourceName, String targetName, Float money) {
        try {
        //1.开启事务
        txManager.beginTransaction();
        //2.执行操作
        //2.1根据名称查询转出账户
        Account source=accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account targetSource=accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户价钱
        targetSource.setMoney(targetSource.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        int i=1/0;
        //2.6更新转入账户
        accountDao.updateAccount(targetSource);
        //3.提交事务
        txManager.commit();
        }catch(Exception e){
        //4.回滚操作
        txManager.rollback();
        e.printStackTrace();
        }finally {
        //5.释放连接
        txManager.release();
        }

    }
}
