package com.huiyalin.controller;

import com.huiyalin.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException方法执行了");
        //模拟异常
        try {
            int a=1/0;
        } catch (Exception e) {
            //打印用户异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户出现错误了...");
        }

        return "success";
    }

}
