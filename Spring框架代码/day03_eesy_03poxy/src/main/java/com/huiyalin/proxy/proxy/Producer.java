package com.huiyalin.proxy.proxy;

import com.huiyalin.proxy.proxy.IProducer;

/*
*  一个生产者
* */
public class Producer implements IProducer {
    /**
     *  销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品并拿到钱"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){

    }
}
