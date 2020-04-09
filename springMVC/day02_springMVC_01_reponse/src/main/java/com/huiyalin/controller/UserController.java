package com.huiyalin.controller;

import com.huiyalin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     *  返回String
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("string执行了");
        //模拟从数据库中查询User对象
        User user=new User();
        user.setName("王刚");
        user.setAge(15);
        user.setPassword("123");
        //model对象存
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 是void 在这里可以分别传参HttpServletRequest 和HttpServletResponse request 和 response对象
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid执行了");
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接会进行相应
        response.getWriter().print("你好");
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("testModelAndView执行了");
        //模拟从数据库中查询User对象
        User user=new User();
        user.setName("王刚");
        user.setAge(15);
        user.setPassword("123");
        //把user对象存储在modelAndView对象中，也会把user对象存储在request对象
        modelAndView.addObject("user",user);
        //跳转到哪个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 模拟异步请求响应
     * @param user
     * @return
     */
    @RequestMapping("/textAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        //客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setName("hh");
        user.setAge(40);
        return user;
    }

}
