package com.huiyalin.test;

import com.huiyalin.dao.AccountDao;
import com.huiyalin.dao.UserDao;
import com.huiyalin.domain.Account;
import com.huiyalin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession=sqlSessionFactory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
         userDao=sqlSession.getMapper(UserDao.class);
    }
    @After//用于在测试方法执行之后执行
    public void destory()throws Exception{
        //提交事务
        sqlSession.commit();//在这里一定要记得写这句Setting autocommit to false mybatis会自动将这个设置成
        //false于是就会回滚
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() {

        //5.使用代理对象执行方法
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println("----------这个user用户---------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }
}
