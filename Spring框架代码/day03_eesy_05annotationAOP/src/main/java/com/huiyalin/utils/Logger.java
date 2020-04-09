package com.huiyalin.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("logger")
//@component： 把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>
//它泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.huiyalin.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
    //在这里没有使用环绕通知需注意他们代码的执行顺序
   // @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法执行了");
    }
    /**
     * 后置通知
     */
   // @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturning方法执行了");
    }
    /**
     * 异常通知
     */
    //@AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger中的afterThrowing方法执行了");
    }
    /**
     * 最终通知
     */
   // @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger中的afterprintlog方法执行了");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于
     *      明确调用切入点方法。该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供接口的
     *      实现类供我们使用
     *
     * Spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
   @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
            Object rtValue=null;
        try {
            Object []args=pjp.getArgs();
            System.out.println("环绕通知Logger中的aroundPrintLog方法执行了...前置");
            rtValue=pjp.proceed(args);
            System.out.println("环绕通知Logger中的aroundPrintLog方法执行了...后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知Logger中的aroundPrintLog方法执行了...异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知Logger中的aroundPrintLog方法执行了...终止");
        }

    }
}
