package com.huiyalin.dao.impl;

import com.huiyalin.dao.AccountDao;
import com.huiyalin.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupper implements AccountDao {

    public Account findAccountById(Integer id) {
        List<Account> list=getJdbcTemplate().query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return list.isEmpty()?null:list.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> list=getJdbcTemplate().query("select * from account where  name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if (list.isEmpty()){
            return null;
        }
        if (list.size()>1){
            throw new RuntimeException("结果不唯一");
        }
        else {
            return list.get(0);
        }
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name=?, money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
