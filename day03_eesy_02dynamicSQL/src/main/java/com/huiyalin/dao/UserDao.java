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
     * 根据queryVo中的条件查询用户
     * @param queryVo
     * @return
     */
    List<User> findByVo(QueryVo queryVo);

    /**
     * 根据传入的参数条件查询
     * @Param user 查询的条件：有可能有用户名，有可能有性别，也有可能有地址，还有可能都有
     * @return
     */
    List<User> findUserByCondition(User  user);

    /**
     * 根据queryVO中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
