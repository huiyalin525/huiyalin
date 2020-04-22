package com.huiyalin.service.impl;


import com.huiyalin.dao.AccountDao;
import com.huiyalin.dao.impl.AccountDaoImpl;
import com.huiyalin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *  曾经的XML配置：
 *  <bean id="accountService" class="com.huiyalin.service.impl.AccountServiceImpl"
 *  scope="" init-method="" destroy="">
 *  <property name="" value="" | ref=""></property>
 *  </bean>
 *
 *  用于创建对象的
 *      他们的作用和在XML配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *      Component:
 *              作用：用于把当前类对象存入spring容器中
 *              属性：
 *                   value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母小写
 *      Controller:一般用在表现层
 *      Service:一般用在业务层
 *      Repository:一般用在持久层
 *      以上三个注解的作用和属性Component是一模一样。
 *      他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *  用于注入数据的
 *      他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的
 *
 *      AutoWired
 *            作用：自动按照类型注入。只要容器中有唯一一个bean对象类型和要注入的变量类型匹配，就可以成功注入
 *                  如果ioc容器中没有任何bean的类型和要注入的变量类型匹配则报错
 *                  如果ioc容器中有多个类型匹配时：先圈定相匹配的类型也就是xml map容器中的value再匹配
 *                  类型定义变量名时的变量名也就是key值
 *            出现位置：可以是变量上，也可以是方法
 *            细节：在使用注解注入时，set方法就不是必须的。
 *
 *      Qualifier:
 *            作用：在按照类中注入的基础上再按照名称注入。它在给类成员注入时不能单独使用。但是给方法参数注入时可以
 *            属性：value，用于指定注入bean的id  *它不能独立使用必须和上面的搭配
 *          以上两个搭配在一起使用才能体现出更好的结果一个定义类名一个定义变量名
 *
 *     Resource:
 *            作用：直接按照bean的id注入。他可以独立使用
 *            属性：
 *                  name:用于指定bean的id。
 *       以上三个注入都只能注入其它bean类型的数据，而基本类型个String类型无法使用以上注解实现。
 *       另外集合类型的注解只能通过xml来实现
 *     Value
 *           作用：用于注入基本类型和String类型的数据
 *           属性：
 *                value：用于指定数据的值。它可以使用spring中SpEl(也就是spring的el表达式)
 *                       SpEl的写法：${表达式}
 *  用于改变作用范围的
 *      他们的作用集合在bean标签中使用scope属性实现的功能一样
 *    Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围取值。常用取值：singleton prototype
 *  和生命周期相关  了解
 *      他们的作用就和bean标签中使用init-method和destroy-method的作用是一样的
 *      PreDestroy
 *         作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */
@Component(value = "accountServiceImpl")//这里的value可以不写但是有两个的话必须写
@Scope("singleton")//多例  和单例
public class AccountServiceImpl implements AccountService {
/*        @Autowired
        @Qualifier("accountDao2")*/
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }
    @PreDestroy
    public void realse (){
        System.out.println("关闭了");//注意关闭在单例才能关
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
