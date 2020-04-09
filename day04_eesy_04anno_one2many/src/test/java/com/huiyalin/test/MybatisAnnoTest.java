package com.huiyalin.test;

import com.huiyalin.dao.UserDao;
import com.huiyalin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis的使用
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1.获取字节输入流
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流给件SQLSessionFactory
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlSessionFactory生产一个SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //4.使用SqlSession获取DAO代理对象
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        //5.使用dao方法
        List<User>users= userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        User user=new User();
        user.setUsername("感刚刚");
        user.setSex("男");
        user.setAddress("你的心里");
        user.setBirthday( new Date());
        userDao.saveUser(user);
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
