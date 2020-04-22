package com.huiyalinalibaba.service.impl;

import com.huiyalinalibaba.dao.AccountDao;
import com.huiyalinalibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long id, BigDecimal money) {
        log.info("-------开始扣钱");
        accountDao.decrease(id,money);
        log.info("-------扣钱完毕");
    }
}
