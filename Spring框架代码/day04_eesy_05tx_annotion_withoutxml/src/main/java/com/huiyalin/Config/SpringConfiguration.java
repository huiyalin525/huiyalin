package com.huiyalin.Config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类相当于bean.xml
 */
@Configuration
@ComponentScan("com.huiyalin")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbcTemplate.properties")//连接到配置文件
@EnableTransactionManagement//开启事务管理的注解支持
public class SpringConfiguration {
}
