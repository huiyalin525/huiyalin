package com.huiyalin.service;

import com.huiyalin.domain.Account;

public interface AccountService {
    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
    /**
     * 通过id查找用户
     * @return
     */
    Account findAccountById(Integer accountId);

}
