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

import java.io.InputStream;

public class SecondLevelCacheTest {
    private InputStream in;

    private SqlSessionFactory sqlSessionFactory;
    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
         sqlSessionFactory=builder.build(in);

    }
    @After//用于在测试方法执行之后执行
    public void destory()throws Exception{

        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
      //在这里sqlSession1和2都是由上面的SQLSessionFactory创建的
      //在SqlMapConfig.xml配置  UserDao.xml配置  select标签中配置
      SqlSession sqlSession1=sqlSessionFactory.openSession();
      UserDao dao1=sqlSession1.getMapper(UserDao.class);
      User user=dao1.selectUserById(41);
      System.out.println(user);
      sqlSession1.close();//一级缓存消失

      SqlSession sqlSession2=sqlSessionFactory.openSession();
      UserDao dao2=sqlSession2.getMapper(UserDao.class);
      User user2=dao2.selectUserById(41);
      System.out.println(user2);
      sqlSession2.close();//一级缓存消失
      System.out.println(user==user2);
      //二级缓存存放的是数据不是对象
      //拿数据的时候就创建了一个新的对象
    }

}
