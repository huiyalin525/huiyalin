package com.huiyalin.controller;

import com.huiyalin.domain.Account;
import com.huiyalin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamsController {
    /**
     * 请求参数入门绑定
     *
     * @return
     */
    @RequestMapping(value = "/testparam")
    public String testParam(String username, String password) {
        System.out.println("执行了");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到javabean的类中
     *
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveUser(Account account) {
        System.out.println("执行好了");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String  saveUser2(User user){
        System.out.println("执行好了");
        System.out.println(user);
        return "success";
 }
    @RequestMapping("/testServlet")
    public void testServlet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println(httpServletRequest);

        HttpSession session=httpServletRequest.getSession();
        System.out.println(session);

        ServletContext  servletContext=session.getServletContext();
        System.out.println(servletContext);
    }
}
