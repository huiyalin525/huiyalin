package com.huiyalin.service.impl;

import com.huiyalin.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int id) {
        System.out.println("执行了更新"+id);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
