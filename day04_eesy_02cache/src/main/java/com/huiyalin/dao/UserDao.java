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
     * 查询一个用户
     * @param UserId
     * @return
     */
    User selectUserById(Integer UserId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
}
