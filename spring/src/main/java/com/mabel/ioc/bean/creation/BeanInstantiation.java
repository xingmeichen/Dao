package com.mabel.ioc.bean.creation;

import com.google.common.collect.Lists;
import com.mabel.domain.User;
import com.mabel.util.DefaultUserFactory;
import com.mabel.util.IUserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @project: JavaLearning
 * @description: Bean的实例化示例
 * @author: Mabel.Chen
 * @create: 2020-02-13 10:35
 **/
public class BeanInstantiation {

    /**
     *  通过构造函数创建Bean
     * */
    public static User createUserByConstructor() {
        return new User();
    }

    /**
     * 通过静态工厂方法创建Bean
     * */
    public static User createUserByStaticFactoryMethod() {
        System.out.println("--------- create user by static method ---------");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation.xml");
        User user = (User) beanFactory.getBean("userByStaticMethod");
        System.out.println(user);
        return user;
    }

    /**
     * 通过实例工厂方法创建Bean
     * */
    public static User createUserByInstanceFactoryMethod() {
        System.out.println("--------- create user by instance method ---------");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation.xml");
        User user = (User) beanFactory.getBean("userByInstanceMethod");
        System.out.println(user);
        return user;
    }

    /**
     * 通过FactoryBean的方式创建Bean
     * */
    public static User createUserByFactoryBean() throws Exception {
        System.out.println("--------- create user by factory bean ---------");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation.xml");
        User user = (User) beanFactory.getBean("userByFactoryBean");
        System.out.println(user);
        return user;
    }


    /**
     * 创建Bean特殊方法一： 通过Service loader创建Bean
     * */
    public static List<User> createUserByServiceLoader() {
        System.out.println("-------- create user by service loader ------------");
        // 注意：该方式需要配置services
        ServiceLoader<IUserFactory> loader = ServiceLoader.load(IUserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<IUserFactory> iterator = loader.iterator();
        List<User> users = Lists.newArrayList();
        while (iterator.hasNext()) {
            IUserFactory iuserFactory = iterator.next();
            User user = iuserFactory.createUser();
            System.out.println(user); // 目前这里的user是null
        }
        return users;
    }

    /**
     * 创建Bean特殊方法二： 通过ServiceLoader创建Bean
     * */
    public static User createUserByServiceLoaderFactoryBean() {
        System.out.println("------------ create user by ServiceLoader ------------");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation.xml");
        ServiceLoader<IUserFactory> serviceLoader = beanFactory.getBean("userServiceLoader", ServiceLoader.class);
        Iterator<IUserFactory> iterator = serviceLoader.iterator();
        return iterator.next().createUser();
    }

    /**
     * 创建Bean特殊方法三：通过AutowireCapableBeanFactory创建Bean
     * */
    public static User createUserByAutoWireCapableFactoryBean() {
        System.out.println("------------ create user by AutowireCapableBeanFactory ------------");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation.xml");
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();

        // 这里要注意的是getBean方法穿的类类型必须是具体类，而不能是接口！！！
        IUserFactory userFactory = autowireCapableBeanFactory.getBean(DefaultUserFactory.class);
        return userFactory.createUser();
    }

    /**
     * 创建Bean特殊方法四： 通过BeanDefinition创建Bean
     * */
    public static User createUserByBeanDefinition() {
        System.out.println("----------- create user by BeanDefinition ----------");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 10000);
        builder.addPropertyValue("name", "Mabel");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        applicationContext.registerBeanDefinition("user", beanDefinition);

        // 手动启动应用上下文（务必注意它的启动时期，在载入配置信息完成后才能启动）
        applicationContext.refresh();

        User user = (User) applicationContext.getBean("user");

        // 手动停止应用上下文
        applicationContext.close();
        return user;
    }

    public static void main(String[] args) throws Exception {
        User user = createUserByBeanDefinition();
        System.out.println(user);
    }
}