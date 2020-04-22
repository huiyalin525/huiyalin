package com.huiyalin.devtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/abc")
    public String hello(){
        return "hello";
    }

}
