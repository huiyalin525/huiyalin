package com.huiyalin.Dao;



import com.huiyalin.domain.Account;

import java.util.List;

/*
 *   账户的持久层接口
 * */
public interface AccountDao {
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
}
