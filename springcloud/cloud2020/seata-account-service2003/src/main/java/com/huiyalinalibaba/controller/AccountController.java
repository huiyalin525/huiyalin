package com.huiyalinalibaba.controller;

import com.huiyalinalibaba.domain.CommonResult;
import com.huiyalinalibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money){
        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountService.decrease(userId,money);

        return new CommonResult(200,"扣除金额成功"+money);
    }
}
