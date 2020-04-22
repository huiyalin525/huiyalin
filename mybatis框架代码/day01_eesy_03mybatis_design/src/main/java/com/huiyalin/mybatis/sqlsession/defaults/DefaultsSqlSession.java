package com.huiyalin.mybatis.sqlsession.defaults;

import com.huiyalin.mybatis.cfg.Configuration;
import com.huiyalin.mybatis.sqlsession.SqlSession;
import com.huiyalin.mybatis.sqlsession.proxy.MapperProxy;
import com.huiyalin.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 */
public class DefaultsSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultsSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.connection= DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
   return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 由于释放资源
     */
    public void close() {
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
