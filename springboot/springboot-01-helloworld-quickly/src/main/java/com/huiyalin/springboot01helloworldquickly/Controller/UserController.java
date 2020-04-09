package com.huiyalin.springboot01helloworldquickly.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*@ResponseBody这个类的所有返回的数据直接写给浏览器，（如果是对象转为json数据）
@ResponseBody
@Controller*/
@RestController//这个是上面两个的结合体
public class UserController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world quick";
    }
}
