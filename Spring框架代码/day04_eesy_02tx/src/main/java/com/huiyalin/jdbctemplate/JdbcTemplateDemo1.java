package com.huiyalin.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源：spring的内置数据源
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.mysql");
        ds.setUrl("jdbc:mysql://localhost:3306/lainxi?useUnicode=true&characterEncoding=UTF-8&serverTimezone=America/New_York&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("000000");
        //1.创建JdbcTemplate
        JdbcTemplate jt=new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name,money) values ('cccc',1000f)");
    }
}
