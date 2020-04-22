package com.huiyalin.utils;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    /**
     * 要求在执行service方法时先通知
     */
    public void printLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法执行了");
    }


}
