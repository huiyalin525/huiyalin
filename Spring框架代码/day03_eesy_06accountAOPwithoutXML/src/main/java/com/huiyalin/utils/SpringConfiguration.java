package com.huiyalin.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.huiyalin")
@Import({ConnectionUtils.class,TransactionManager.class,AccountAop.class,JdbcConfig.class})
@EnableAspectJAutoProxy
@PropertySource("classpath:jdbcconfig.properties")
public class SpringConfiguration {
}
