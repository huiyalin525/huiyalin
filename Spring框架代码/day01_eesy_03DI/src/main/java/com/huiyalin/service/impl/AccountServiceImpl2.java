package com.huiyalin.service.impl;



import com.huiyalin.service.AccountService;

import java.util.Date;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {
    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("保存了"+":"+name+","+age+","+birthday);;
    }

}
