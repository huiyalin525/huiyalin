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
import java.util.Date;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;
    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
         sqlSessionFactory=builder.build(in);
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

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User user=userDao.selectUserById(41);

        System.out.println(user);
/*        sqlSession.close();
        //重新开启也可以清除缓存
        //再次获取sqlSession对象
        sqlSession=sqlSessionFactory.openSession();*/
        sqlSession.clearCache();//此方法也可以清除缓存
        userDao=sqlSession.getMapper(UserDao.class);
        User user2=userDao.selectUserById(41);
        System.out.println(user2);
        /*运行结果可以看出他是只查了一次
        com.huiyalin.domain.User@291ae
        com.huiyalin.domain.User@291ae
        true*/
        System.out.println(user==user2);
    }
    @Test
    public void testClearCache(){
        User user = null;
        //查询id为51的用户
        user=userDao.selectUserById(51);
        //修改
        user.setName("wang");
        user.setAddress("gaolaozhuang");
        userDao.updateUser(user);

        //再次查询
        User user2=userDao.selectUserById(51);
        System.out.println(user2);
        System.out.println(user==user2);
        //一级缓存是sqlSession范围的缓存，当调用sqlSession的修改，添加，删除，commit()，close()
        //等方法时就会清空一级缓存
    }
}
