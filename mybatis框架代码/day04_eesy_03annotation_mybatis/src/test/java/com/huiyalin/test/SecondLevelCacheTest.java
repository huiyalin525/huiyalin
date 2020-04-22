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
import java.util.List;

public class SecondLevelCacheTest {
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

        in.close();
    }

    @Test
    public void testFindById(){
       SqlSession sqlSession=sqlSessionFactory.openSession();
       UserDao userDao=sqlSession.getMapper(UserDao.class);
        User user1=userDao.findById(57);
        System.out.println(user1);
        sqlSession.close();//释放一级缓存

        SqlSession sqlSession1=sqlSessionFactory.openSession();
        UserDao userDao1=sqlSession1.getMapper(UserDao.class);
        User user2=userDao1.findById(57);
        System.out.println(user2);
        sqlSession1.close();
}
}
