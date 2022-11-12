package com.dao.ioc.bean.scope;

import com.dao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @project: JavaLearning
 * @description: 理解Bean的作用域
 * 结论：
 * 1、Singleton Bean, 无论是依赖查找还是依赖注入, 均为同一个对象
 * 2、Prototype Bean, 无论是依赖查找还是依赖注入, 均为新增的对象
 * 3、如果依赖注入集合类型对象，Singleton Bean 和 Prototype Bean 均只存在一个，并且这里的Prototype Bean 有别于其他地方的Prototype Bean
 * 4、无论是 Singleton Bean 还是 Prototype Bean 均会执行初始化方法回调，但是只有Singleton Bean 会执行销毁方法回调
 * @author: Mabel.Chen
 * @create: 2020-02-13 10:59
 **/
public class BeanScope {


    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    @Bean
    public User singletonUser() {
        User user = User.createUser();
        user.setId(Double.doubleToLongBits(Math.random()));
        return user;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User prototypeUser() {
        User user = User.createUser();
        user.setId(Double.doubleToLongBits(Math.random()));
        return user;
    }

    public static void singletonScope() {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-scope.xml");
        User user = (User) beanFactory.getBean("user");
        User user1 = (User) beanFactory.getBean("user");
        /**
         * 结果为true, 说明是作用域是singleton,再看bean-scope.xml中user的配置，
         * 并没有显式定义作用域，所以说明singleton是默认的作用域
         * */
        System.out.println(user == user1); // true
    }

    public static void prototypeScope() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-scope.xml");
        User otherUser = (User) beanFactory.getBean("otherUser");
        User otherUser1 = (User) beanFactory.getBean("otherUser");
        /**
         * 结果为false, 说明otherUser的作用域为non-singleton,
         * 再看bean-scope.xml中user的配置，otherUser被显式定义了作用域为prototype
         * */
        System.out.println(otherUser == otherUser1); // false
    }

    /***
     * 该方法输出结果说明：
     * 1、singleton 作用域的Bean唯一
     * 2、
     * */
    private static void scopeBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            System.out.println("singletonUser = " + singletonUser);

            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser = " + prototypeUser);
        }
    }

    private static void scopeBeansByInject(AnnotationConfigApplicationContext applicationContext) {
        BeanScope bean = applicationContext.getBean(BeanScope.class);
        System.out.println("singletonUser = " + bean.singletonUser);
        System.out.println("prototypeUser = " + bean.prototypeUser);
        System.out.println("prototypeUser1 = " + bean.prototypeUser1);
        System.out.println("prototypeUser2 = " + bean.prototypeUser2);
        System.out.println("users = " + bean.users);
    }

    public static void main(String[] args) {
        
        singletonScope();
        prototypeScope();

        System.out.println("---------- ************************************** ------------");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanScope.class);
        applicationContext.refresh();

        scopeBeansByLookup(applicationContext);
        System.out.println("---------- ************************************** ------------");
        scopeBeansByInject(applicationContext);

        applicationContext.close();
    }
}