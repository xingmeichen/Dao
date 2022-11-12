package com.dao.ioc.bean.dependency.lookup;

import com.dao.domain.User;
import com.dao.domain.UserAnnotation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @project: JavaLearning
 * @description:  依赖查找
 * @author: Mabel.Chen
 * @create: 2020-02-13 12:15
 **/
public class DependencyLookup {

    public static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时依赖查找：" + user);
    }

    public static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        System.out.println("延迟查找：" + objectFactory.getObject());
    }

    public static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    public static void lookupColletionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有User类型的对象：");
            beans.forEach((beanName, bean) -> System.out.println(bean));
        }
    }

    public static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(UserAnnotation.class);
            System.out.println("查找所有标记了UserAnnotation注解的对象：");
            beans.forEach((beanName, bean) -> System.out.println(bean));
        }
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
        lookupByType(beanFactory);
        System.out.println("---------------------");
        lookupColletionByType(beanFactory);
        lookupByAnnotation(beanFactory);
    }
}