package com.huiyalin.ui;


import com.huiyalin.dao.AccountDao;
import com.huiyalin.service.AccountService;
import com.huiyalin.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client  {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     *
     *  ApplicationContext的三个常用类
     *      ClassPathXmlApplicationContext; 他可以加载类路径下的配置文件，要求配置文件必须在类路径之下，不在的话加载不了
     *      FileSystemApplication   它可以加载磁盘任意路径下的配置文件(必须有访问权限)
     *      AnnotationConfigApplication 它是用于读取朱姐创建容器的
     *
     *   核心容器的两个接口引发出的问题:
     *      ApplicationContext: 单例对象适用  采用此接口
     *          它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     *      BeanFactory:        多例对象适用
     *          它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象，什么时候才真正的创建对象
     *
     */
    public static void main(String[] args) {

        /*//1.获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountService as=(AccountServiceImpl)ac.getBean("accountService");
        AccountDao ad=ac.getBean("accountDao",AccountDao.class);
        System.out.println(as);
        System.out.println(ac);
        //accountService.saveAccount();*/
        Resource resource =new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        AccountService accountService=(AccountService)factory.getBean("accountService");
        System.out.println(accountService);
    }
}
