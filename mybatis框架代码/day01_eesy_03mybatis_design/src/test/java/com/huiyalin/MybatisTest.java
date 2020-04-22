package com.huiyalin;

import com.huiyalin.dao.UserDao;
import com.huiyalin.domain.User;
import com.huiyalin.mybatis.io.Resources;
import com.huiyalin.mybatis.sqlsession.SqlSession;
import com.huiyalin.mybatis.sqlsession.SqlSessionFactory;
import com.huiyalin.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {

    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
