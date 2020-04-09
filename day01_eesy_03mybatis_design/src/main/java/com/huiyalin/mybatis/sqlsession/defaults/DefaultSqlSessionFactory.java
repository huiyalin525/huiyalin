package com.huiyalin.mybatis.sqlsession.defaults;

import com.huiyalin.mybatis.cfg.Configuration;
import com.huiyalin.mybatis.sqlsession.SqlSession;
import com.huiyalin.mybatis.sqlsession.SqlSessionFactory;
import com.huiyalin.mybatis.utils.DataSourceUtil;

/**
 * SqlSessionFactory的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;


    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultsSqlSession(cfg);
    }
}
