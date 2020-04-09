package com.huiyalin.mybatis.sqlsession.proxy;

import com.huiyalin.mybatis.cfg.Mapper;
import com.huiyalin.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    //map的key是全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }
    /**
     * 用于对方法进行增强，我们的增强其实就是调用selectlist方法
     * @param proxy   代理对象的引用
     * @param method  当前执行的方法
     * @param args    当前执行方法所需要的参数
     * @return        和被代理对象有相同的返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName=method.getName();
        //2.获取方法所在类的名称
        String className=method.getDeclaringClass().getName();
        //3.组合key
        String key=className+"."+methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper=mappers.get(key);
        //5.判断以下是否有mapper
        if (mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
