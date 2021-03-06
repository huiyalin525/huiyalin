package com.huiyalin.Dao.impl;

import com.huiyalin.Dao.AccountDao;
import com.huiyalin.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return queryRunner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveAccount(Account account) {
        try {
             queryRunner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByAccountId(Integer accountId) {
        try {
            queryRunner.update("delete from account where id=?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
