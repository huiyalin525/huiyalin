package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *   该类是一个配置类，它的作用个bean.xml是一样的
 *   spring中的新注解
 *   configuration
 *      作用：只当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigurationContext对象创建的参数时，该注解可以不写
 *   ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。在这里可以点开源码看
 *                 我们使用此注解就等同于在xml中配置了:
 *                 <context:component-scan base-package="com.huiyalin"></context:component-scan>
 *   Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性：
 *           name：用于指定bean的id。当不写使默认当前方法的名称
 *      细节：
 *          当我们使用注解配置时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的
 *   Import
 *       作用：用于导入其他的配置类
 *       属性：
 *          value：用于指定其他配置类的字节码。
 *                 当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的都是子配置类
 *   PropertySource
 *       作用：用于指定properties文件的位置
 *       属性：
 *          value：指定文件的名称和路径
 *                 关键字：classpath，表示类路径下
 */
//@Configuration在这里如果写多个配置类的时候就需要写多个Configuration 或者还需要给AnnotationConfigurationContext这个方法加入多余的配置类且他们是兄弟关系
//这时就过于麻烦在这里就有了import注解
@ComponentScan(basePackages = "com.huiyalin")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcconfig.properties")//如果不这样写的话就会将配置类中的数据库信息给写死
public class SpringConfiguration {

}
