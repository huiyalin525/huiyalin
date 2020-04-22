package com.huiyalin.service;

import com.huiyalin.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    void saveAccount(Account account);
}
