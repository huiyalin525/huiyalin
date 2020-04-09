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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void Init() throws Exception{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        sqlSession=sqlSessionFactory.openSession();
        accountDao=sqlSession.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts=accountDao.findAll();
        for (Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUsers());
        }
    }
    /*@Test
    public void testFindById(){
        User user=userDao.findById(57);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        List<User>users=accountDao.findByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }*/

}
