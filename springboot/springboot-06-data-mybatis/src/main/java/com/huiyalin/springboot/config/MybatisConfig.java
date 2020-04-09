package com.huiyalin.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//这个配置类的作用是当封装类没变而方法中的类变了以后配置mybatis
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
       return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
             configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

}
