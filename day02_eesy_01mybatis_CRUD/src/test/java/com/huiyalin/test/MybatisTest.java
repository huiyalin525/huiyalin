package com.huiyalin.test;

import com.huiyalin.dao.UserDao;
import com.huiyalin.domain.QueryVo;
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

/**
 * mybatis的入门案例
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private User user;
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
    /**
     * 入门案例
     *
     */
    @Test
    public void testFindAll() {

        //5.使用代理对象执行方法
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     *
     * @throws Exception
     */
    @Test
    public void testSaveUser() {
       user=new User();
       user.setUserName("王贺");
       user.setUserAddress("王家岭");
       user.setUserBirthday(new Date());

       user.setUserSex("男");
        //5.使用代理对象执行方法
       userDao.saveUser(user);
       System.out.println(user);

 }
    @Test
    public void testUpdateUser(){
        user=new User();
        user.setUserid(49);
        user.setUserName("王佳");
        user.setUserAddress("王家山");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        //5.使用代理对象执行方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除方法
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(52);

    }
    /**
     * 测试查询一个用户方法
     */
    @Test
    public void testSelectUserById(){
        user=userDao.selectUserById(51);
        System.out.println(user);
    }
    /**
     * 测试通过名字查询方法
     */
    @Test
    public void testFindByName(){
        List<User> users= userDao.findByName("%王%");
        //List<User> users= userDao.findByName("王");第二种方法
        for (User user:users){
            System.out.println(user);
        }
    }

    /**
     * 查询总记录条数
     */
    @Test
    public void testFindTotal (){
        System.out.println(userDao.findTotal());
    }

    /**
     *
     */
    @Test
    public void testFindByVo(){
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUserName("%王%");
        queryVo.setUser(user);
        List<User> users= userDao.findByVo(queryVo);
        //List<User> users= userDao.findByName("王");第二种方法
        for (User user1:users){
            System.out.println(user1);
        }
    }
}
