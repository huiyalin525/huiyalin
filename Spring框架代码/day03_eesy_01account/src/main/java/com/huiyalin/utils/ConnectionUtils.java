package com.huiyalin.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
* 连接的工具类，它用于从数据源中获取一个连接，并实现和线程的绑定
* */
public class ConnectionUtils {

    private ThreadLocal<Connection> t1=new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){

        try {
            //1.先从ThreadLocal上获取
            Connection conn=t1.get();
            //2.判断当前线程上是否有连接
            if (conn==null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn=dataSource.getConnection();
                t1.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    *   在这里当线程用完之后会将该线程还回去但是呢该线程上绑着一个连接池所以要再次使用这个线程时则不能使用
    * 所以必须在他使用完时将现在的局部变量删除也就是将绑定的connection给删除从而保证下一次线程为空可以继续使用
    * */
    public void removeConnection(){
        t1.remove();
    }
}
