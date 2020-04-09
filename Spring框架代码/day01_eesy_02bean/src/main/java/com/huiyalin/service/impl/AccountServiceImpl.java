package com.huiyalin.service.impl;



import com.huiyalin.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    public void saveAccount() {
        System.out.println("保存了");;
    }
    public void init() {
        System.out.println("创建了");;
    }
    public void destory() {
        System.out.println("销毁了-");;
    }
}
