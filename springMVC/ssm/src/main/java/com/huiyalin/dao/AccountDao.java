package com.huiyalin.dao;

import com.huiyalin.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {

    @Select("select * from accountt")
    List<Account> findAll();
    @Insert("insert into accountt(name,money)values(#{name},#{money})")
    void saveAccount(Account account);
}
