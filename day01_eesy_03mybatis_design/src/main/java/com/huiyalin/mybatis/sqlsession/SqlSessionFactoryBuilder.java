package com.huiyalin.mybatis.sqlsession;

import com.huiyalin.mybatis.cfg.Configuration;
import com.huiyalin.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.huiyalin.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SQLSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     *  根据参数的字节输入流来创建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg= XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
