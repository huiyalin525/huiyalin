package com.huiyalin.test;

import com.huiyalin.dao.AccountDao;

import com.huiyalin.domain.Account;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;

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
         accountDao=sqlSession.getMapper(AccountDao.class);
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
        List<Account> accounts=accountDao.findAll();
        for (Account account:accounts){
            System.out.println("----------这个account用户---------");
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }
}
