package com.huiyalin.controller;

import com.huiyalin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//把msg=小美存入到session域对象中一份
public class AnnoController {

    @RequestMapping("/testRequestParam")
    //在这里RequestParam里的value值必须与jsp传过来参数名一致
    public String testRequestParam(@RequestParam(value = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * RequestBody 是用来拿地址栏中正请求体
     * @param body
     * @return
     */
    @RequestMapping(value = "/testRequestBody")
    //在这里RequestParam里的value值必须与jsp传过来参数名一致
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        String s= null;
        try {
            s = URLDecoder.decode(body,"UTF-8");//解决乱码问题
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return "success";
    }
    @RequestMapping(value = "/testPathVariable/{sid}")

    public String testPathVariable(@PathVariable(name = "sid")String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头部信息的值
     * @param id
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "accept")String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取cookie的值
     * @param cookValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID")String cookValue){
        System.out.println("执行了");
        System.out.println(cookValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * 当从浏览器获取的值不足以封装该对象时，可以使用ModelAttribute提前让一个方法先执行从数据库中获取字段名添加条件
     * 来满足封装条件进而更好的封装
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("ModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * 当没有返回值的时候可以将它存在一个map容器中然后在调用
     * @param uname
     * @param map
     */
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser方法执行了");
        User user=new User();
        user.setUname(uname);
        user.setName(12);
        user.setDate(new Date());
        map.put("abc",user);

    }

    /**
     * 该方法会先执行
     * @param uname
     * @return

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser方法执行了");
        User user=new User();
        user.setUname(uname);
        user.setName(12);
        user.setDate(new Date());
        return user;
    }
    */
    /**
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes");
        //底层会存储到request域对象中
        model.addAttribute("msg","小美");
        return "success";
    }

    /**
     * 获取值
     * @param model
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(Model model){
        System.out.println("getSessionAttributes");
        String msg= (String) model.getAttribute("msg");
        System.out.println(msg);
        return "success";
    }
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus){
        System.out.println("getSessionAttributes");
        sessionStatus.setComplete();

        return "success";
    }

}
