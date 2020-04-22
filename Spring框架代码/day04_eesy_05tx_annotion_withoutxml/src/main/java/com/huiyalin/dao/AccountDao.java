package com.huiyalin.dao;

import com.huiyalin.domain.Account;

/**
 * 账户的持久层接口
 */
public interface AccountDao {
    /**
     * 根据Id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据姓名查询账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     * @return
     */
    void updateAccount(Account account);
}
