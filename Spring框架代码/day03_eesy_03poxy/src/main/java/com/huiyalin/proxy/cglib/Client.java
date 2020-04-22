package com.huiyalin.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 模拟一个消费者
* */
public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();

        /*
        *    JDK动态代理的一般步骤如下：
        *
        *    1、创建被代理的接口和类；
        *
        *    2、实现InvocationHandler接口，对目标接口中声明的所有方法进行统一处理；
        *
        *    3、调用Proxy的静态方法，创建代理类并生成相应的代理对象；
        *
        *     4、使用代理。
        *
        *
        * 动态代理：
        *   特点：字节码随用随创建，随用随加载
        *   作用：不修改源码的基础上对方法增强
        *   分类：
        *       基于接口的动态代理
        *       基于子类的动态代理
        *   基于子类的动态代理：
        *       涉及的类：Enhancer
        *       提供者：第三方cglib库
        *   如何创建代理对象：
        *       使用Enhancer类中的create方法
        *   创建代理对象的要求：
        *       被代理最少实现一个接口，如果没有则不能使用
        *   create方法的参数：
        *       Class:字节码
        *           它是用于指定被代理对象的字节码
        *       callback:用于提供增强的代码
        *            它是让我们写如何代理。我们一般都是写一些该方法的实现类，通常情况下都是匿名内部类，但不是必须的
        *            我们一般写的都是该接口的子接口实现类：MethodInterceptor
        * */
        Producer cigProducer= (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *  执行被代理的对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             *  以上三个参数和基于接口的动态代理中invoke方法中的参数是一样的
             * @param methodProxy：当前执行方法的代理对象
             *
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强代码
                Object returnValue = null;
                //1.获取方法执行的参数
                Float money = (Float) args[0];
                //2.判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);//在这里匿名内部类中若要访问外部成员变量时，外部成员要求是最终的
                }
                return returnValue;
            }
        });
        cigProducer.saleProduct(12000f);
    }
}
