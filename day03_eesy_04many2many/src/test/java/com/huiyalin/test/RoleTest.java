package com.huiyalin.test;

import com.huiyalin.dao.RoleDao;
import com.huiyalin.dao.UserDao;
import com.huiyalin.domain.Role;
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

public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;
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
         roleDao=sqlSession.getMapper(RoleDao.class);
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
        List<Role> roles=roleDao.findAll();
        for (Role role:roles){
            System.out.println("----------这个role用户---------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }

    }
}
