package com.huiyalin.proxy.cglib;

/*
*  一个生产者
* */
public class Producer {
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
