package com.huiyalin.dao;

import com.huiyalin.domain.User;

import java.util.List;

/**
 * 用户的持久层方法
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 保存方法
     * @param user
     */
    void saveUser(User user);
}
