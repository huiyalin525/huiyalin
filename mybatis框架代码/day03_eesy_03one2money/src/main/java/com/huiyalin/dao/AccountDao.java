package com.huiyalin.dao;

import com.huiyalin.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();
}
