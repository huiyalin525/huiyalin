package com.huiyalin.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *  一个创建Bean对象的工厂
 *
 *  Bean：在计算机英语中，有可重用组件的含义
 *  javaBean：用java语言编写的可重用组件
 *          javabean > 实体类他不等
 *   它就是创建我们的service和dao对象的。
 *
 *   第一个:需要一个配置文件来配置我们的service和dao
 *          配置的内容：唯一标识=全限定类名(key=value)
 *   第二个:通过读取配置文件中配置的内容，反射创建对象
 *
 *   我的配置文件可以是xml也可以是properties
 */

public class BeanFactory {
    //定义一个Properties
    private static Properties props;

    //定义一个Map，用于存放我们创建的对象。我们把它称之为容器
    private static Map<String,Object>beans;
    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props=new Properties();
            //获取Properties文件的流对象
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");
            props.load(in);
            //实例化容器
            beans=new HashMap<String, Object>();
            Enumeration keys=props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key=keys.nextElement().toString();
                //根据key获取value
                String beanpath=props.getProperty(key);
                //反射创建对象
                Object value=Class.forName(beanpath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }

        } catch (Exception e) {
            throw new  ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
/*    */
    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return
     *//*
    public static Object getBean(String beanName){
        Object bean=null;

        try {
            String beanpath=props.getProperty(beanName);
            bean=Class.forName(beanpath).newInstance();//每次都会调用默认构造函数创建对象
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
