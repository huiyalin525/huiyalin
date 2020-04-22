package com.huiyalincloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.huiyalincloudalibaba.dao"})
public class MybatisConfig {
}
