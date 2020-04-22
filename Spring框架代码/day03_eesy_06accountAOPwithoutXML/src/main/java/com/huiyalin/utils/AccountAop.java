package com.huiyalin.utils;

import com.huiyalin.service.AccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect//切面
public class AccountAop {
    @Autowired
    private TransactionManager txManager;
    //切点获取方法
    @Pointcut("execution(* com.huiyalin.service.impl.*.*(..))")
    public void advice(){}
    //环绕通知
    @Around("advice()")
    public Object arroundAccountAdvice(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object []args=pjp.getArgs();
            txManager.beginTransaction();//前置通知
            rtValue=pjp.proceed(args);
            txManager.commit();//后置通知
            return rtValue;
        } catch (Throwable throwable) {
            txManager.rollback();//异常通知
            throw new RuntimeException(throwable);
        }finally {
            txManager.release();//返回通知
        }
    }

}
