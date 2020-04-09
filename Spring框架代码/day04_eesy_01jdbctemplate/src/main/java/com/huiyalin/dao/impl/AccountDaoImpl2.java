package com.huiyalin.dao.impl;

import com.huiyalin.dao.AccountDao;
import com.huiyalin.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的持久层实现类
 */
//在这里这个JdbcDaoSupport可以自己写也可以用java提供的jar包用jar则不能用注解@Autowired请分情况使用
public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {



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
