package com.huiyalin;

import com.huiyalin.domain.Account;
import com.huiyalin.service.AccountService;
import com.huiyalin.utils.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private AccountService as;

    @Test
    public void transferMoneyTest(){
        as.transfer("aaa","bbb",200f);
        List<Account> list=as.findAllAccount();
        for(Account lists:list){
            System.out.println(lists);
        }
    }
}
