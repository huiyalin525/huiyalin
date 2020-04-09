package com.huiyalin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器类
 */
@Controller
//用于建立请求URL和处理请求方法之间的对应关系
@RequestMapping(path ="/user")
public class HelloController {
    /**
     * 比如说注解request长一点/user/hello
     * method可以用于指定访问方式
     * @RequestMappomh(value="",method={RequestMethod.post},params={"属性名"})表示只能用post方式访问
     * params用于传网页信息栏中的key值在访问该方法或该类的请求是必须携带有属性名及其值，若属性名后有值则发请求
     * 时必须和属性名一样   当以上标签出现两个时他们的关系是与
     * @return
     */
    @RequestMapping(path ="/hello")
    //这个注解可以放在方法上也可以放在类上
    public String Hello(){
        System.out.println("hello");
        return "success";
    }
}
