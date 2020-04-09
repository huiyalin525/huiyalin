package com.huiyalin.service;



import com.huiyalin.domain.Account;

import java.util.List;

/*
*   账户的业务层接口
*   在这里所有的方法在AOP中都是连接点，在invoke中被截住的点都是切入点，是切入点一定是连接点，是连接点就不一定是切入点
* */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 通过id查找用户
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 插入一个用户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 修改用户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 通过id删除一个用户
     * @param accountId
     */
    void deleteByAccountId(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
