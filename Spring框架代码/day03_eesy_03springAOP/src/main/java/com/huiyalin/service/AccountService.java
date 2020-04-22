package com.huiyalin.service;

/*
*   账户的业务层接口
* */
public interface AccountService {
    /*
    *  模拟保存账户
    **/
    void saveAccount();

    /**
     * 模拟账户更新
     * @param id
     */
    void updateAccount(int id);

    /**
     *  删除账户
     * @return
     */
    int deleteAccount();
}
