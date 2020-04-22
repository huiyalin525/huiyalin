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

    /**
     *  根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有就返回null
     *          如果结果中有超过一个就返回异常
     */
    Account findAccountByName(String accountName);

}
