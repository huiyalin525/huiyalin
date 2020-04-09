package com.huiyalin.dao;

import com.huiyalin.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 在mybatis中针对，CRUD一共有四个注解
 * @Select @Update @Delete @Insert
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select(value = "select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user (username,sex,birthday,address) values(#{username},#{sex},#{birthday},#{address})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 通过id删除用户
     */
    @Delete("delete from user where id=#{id}")
    void deleteUserById(Integer id);

    /**
     * 通过id查找一个用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);

    /**
     * 通过姓名模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName(String name);

    /**
     * 查询总个数
     * @return
     */
    @Select("select count(*) from user ")
    int findTotal();
}
