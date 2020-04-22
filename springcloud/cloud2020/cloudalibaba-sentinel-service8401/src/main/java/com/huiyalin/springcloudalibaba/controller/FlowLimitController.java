package com.huiyalin.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){

        return "-------------A";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+".....B");
        return "-------------B";
    }
    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("测试RT");
        return "--------------D";
    }
    @GetMapping("/testE")
    public String testE(){

        log.info("测试异常比例");
        int age = 10/0;
        return "--------------D";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_HotKey")//名字随意只要唯一这里是方便辨认 blockHandler是遇到错以后的兜底方法
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "-------------测试热点";
    }
    //当抛出异常时执行 兜底方法 降级的方法
    public String deal_HotKey(String p1, String p2, BlockException exc){
        return "-------------兜底测试热点";
    }
}
