package com.huiyalin.factory;

import com.huiyalin.domain.Account;
import com.huiyalin.service.AccountService;
import com.huiyalin.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 用于创建service的代理对象工厂
* */
public class BeanFactory {

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    private TransactionManager txManager;

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取service代理对象
     * @return
     */
    public AccountService getAccountService() {
     return  (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * 添加事务的支持
                      * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
            //整个的invoke方法就是在执行环绕通知
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue=null;
                try {
                    //1.开启事务
                    txManager.beginTransaction();//在invoke之前前置通知
                    //2.执行操作
                    rtValue= method.invoke(accountService,args);//在环绕通知中有明确的切入点方法调用
                    //3.提交事务
                    txManager.commit();//后置通知
                    //4.返回结果
                    return rtValue;
                }catch(Exception e){
                    //5.回滚操作
                    txManager.rollback();//异常通知
                    throw new RuntimeException(e);
                }finally {
                    //6.释放连接
                    txManager.release();//最终通知
                }
                    }
                });
    }
}
