package com.dao.ioc.metadata;

import com.google.common.collect.Maps;
import com.dao.domain.Student;
import com.dao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.util.UserFactory;

import java.util.Map;

/**
 * @project: JavaLearning
 * @description: 基与xml文件的元数据配置
 * @author: Mabel.Chen
 * @create: 2020-02-08 20:50
 **/
public class XmlBaseConfig {

    /**
     * 通过 {@link ClassPathXmlApplicationContext} 类读取xml文件配置的元数据
     * */
    public static void loadXmlByClassPath() {
        /**
         * 这个动作做了两件事情（看源码就可以知道，它做的这两个动作分别调用的方法）：
         * 1、配置XML文件 （setConfigLocations(...)）
         * 2、启动应用上下文 refresh()
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/xml-base-config.xml");


        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
        Student student = beanFactory.getBean(Student.class);
        System.out.println(student);
    }

    /**
     * 通过 {@link XmlBeanDefinitionReader} 类读取xml文件配置的元数据
     * */
    public static void loadXmlByReader() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/xml-base-config.xml");
        listBean(beanFactory);
    }

    public static Map<String, User> listBean(BeanFactory beanFactory) {
        Map<String, User> users = Maps.newHashMap();
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            users = listableBeanFactory.getBeansOfType(User.class);
            users.forEach((name, object) -> {
                System.out.println("name" + name + "->" + object);
            });
        }
        return users;
    }

    public static void lookupMethodPropertyOfBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserFactory.class).getBeanDefinition();
        applicationContext.registerBeanDefinition("userFactory", beanDefinition);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");
        // 手动启动应用上下文
        applicationContext.refresh();

        /**
         * 对于 xml 文件中的 bean 的 lookup-method属性说明：
         * 它用来指示Spring去注入/重写该方法，以便从容器中返回特定的bean，
         * 一般这种情况下，需要被返回的这个bean的作用域是是non-singleton
         *
         * 注意看 dependency-lookup.xml 配置文件，配置了lookup也就是依赖查找之后，UserFactory被增强（Enhance）了，
         * createUser实际上并没有被调用，也就是createUser被覆盖掉了，对与user这个Bean的创建交给了Spring容器去做，
         * 所以如下的结果中，因为user这个Bean的作用域是singleton, 故而 user == user1 是 true
         * 如果没有为UserFactory配置lookup,那么UserFactory没有被增强，user 分别调用了 user1
         * */
        UserFactory userFactory = (UserFactory) applicationContext.getBean("userFactory");
        User user = userFactory.createUser();
        User user1 = userFactory.createUser();
        System.out.println(user == user1);

        // 手动关闭应用上下文
        applicationContext.close();
    }

    public static void main(String[] args) {
        loadXmlByClassPath();
    }
}