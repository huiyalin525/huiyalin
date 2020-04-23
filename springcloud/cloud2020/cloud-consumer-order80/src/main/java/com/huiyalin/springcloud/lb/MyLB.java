package com.huiyalin.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
       int index=getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
    public final int getAndIncrement(){

        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));//自旋循环如果next与current（期望值）一样就修改返回true
        System.out.println("*****next:"+next);//然后打出当前值是0还是1
        return next;
    }
}