package com.huiyalin.dao;

import com.huiyalin.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在mybatis中针对，CRUD一共有四个注解
 * @Select @Update @Delete @Insert
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select(value = "select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "address",column = "address"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.huiyalin.dao.AccountDao.findById",fetchType = FetchType.LAZY))
    })
   /* @Results(id="userMap", value ={
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName")}
    )
    当实体类中的变量名与数据库中的变量名不一致时可以这样一一对应
    */
    List<User> findAll();


    /**
     * 通过id查找一个用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    /*@ResultMap(value = {"userMap"})
    * 当使用这个注解将会引用上面的
    * */

    User findById(Integer userId);

    /**
     * 通过姓名模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName(String name);


}
