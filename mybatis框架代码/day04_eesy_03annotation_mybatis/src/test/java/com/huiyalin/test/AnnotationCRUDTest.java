package com.huiyalin.test;

import com.huiyalin.dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void Init() throws Exception{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        sqlSession=sqlSessionFactory.openSession();
        userDao=sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println("---------用户信息----------");
            System.out.println(user);
            System.out.println(user.getAccounts());


        }
    }
    @Test
    public void testFindById(){
        User user=userDao.findById(57);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        List<User>users=userDao.findByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }

}
