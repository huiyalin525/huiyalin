package com.huiyalinalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.huiyalinalibaba.dao"})
public class MybatisConfig {
}
