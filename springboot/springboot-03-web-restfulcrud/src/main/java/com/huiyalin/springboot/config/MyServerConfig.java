package com.huiyalin.springboot.config;

import com.huiyalin.springboot.Filter.MyFilter;
import com.huiyalin.springboot.listener.MyListener;
import com.huiyalin.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import java.util.Arrays;

@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<MyServlet> registrationBeann = new ServletRegistrationBean<>(new MyServlet(),"/myservlet");
        return registrationBeann;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return listenerRegistrationBean;
    }
    //配置嵌入式的Servlet容器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
            return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
                //定制嵌入式的Servlet容器的相关规则
                @Override
                public void customize(ConfigurableServletWebServerFactory factory) {
                    factory.setPort(8083);
                }
            };

    }

}
