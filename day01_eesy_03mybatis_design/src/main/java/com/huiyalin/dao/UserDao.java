package com.huiyalin.dao;

import com.huiyalin.domain.User;
import com.huiyalin.mybatis.annotation.Select;


import java.util.List;

/**
 * 用户的持久层方法
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select *from user")
    List<User> findAll();
}
