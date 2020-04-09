package com.huiyalin.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${jdbc.passWord}")
    private String passWord;

    @Bean(name = "runner")
    @Scope(scopeName = "prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource cpb=new ComboPooledDataSource();
            cpb.setDriverClass(driver);
            cpb.setJdbcUrl(url);
            cpb.setUser(userName);
            cpb.setPassword(passWord);
            return cpb;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
}
