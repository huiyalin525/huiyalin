package com.huiyalin.security.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/level1/**").hasRole("VIP1")
            .antMatchers("/level2/**").hasRole("VIP2")
            .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能，效果，如果没有登录，没有权限就会来到登录页面
        //.loginpage来到自己指定的登录页面
        http.formLogin().usernameParameter("username").passwordParameter("pwd").loginPage("/userlogin");
        //1、/login来到登录页面
        //2、重定向到/login?error表示登录失败
        //3、更多详细规定
        //4、默认post形式的/login代表处理登陆
        //5、usernameParameter指定的是用户名name也就是form表单中的input 中的name属性
        //6、一旦定制loginPage:那么loginPage的post请求就是登录

        //开启自动配置的注销功能。
        http.logout().logoutSuccessUrl("/userlogin");//注销成功以后来到首页
        //1、访问/logout表示用户注销，清空session
        //2、注销成功会返回/login?logout 页面

        //开启记住我功能
        //默认14天过期 它会记住cookie
        http.rememberMe().rememberMeParameter("remember");
        //登录成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
    }
    //定义认证的规则
    //认证密码需要加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1")
            .and()
            .passwordEncoder(new BCryptPasswordEncoder()).withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2")
            .and()
            .passwordEncoder(new BCryptPasswordEncoder()).withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP3");
    }
}
