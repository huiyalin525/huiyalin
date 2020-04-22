package com.huiyalin.dao;

import com.huiyalin.domain.QueryVo;
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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除
     * @param userID
     */
    void deleteUser(Integer userID);

    /**
     * 查询一个用户
     * @param UserId
     * @return
     */
    User selectUserById(Integer UserId);

    /**
     * 通过姓名模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param queryVo
     * @return
     */
    List<User> findByVo(QueryVo queryVo);

}
