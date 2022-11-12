package com.dao.ioc.bean.dependency.injection;

import com.dao.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project: JavaLearning
 * @description: 延时注入示例
 * @author: Mabel.Chen
 * @create: 2020-02-16 11:48
 **/
public class LazyDependencyInject {

    /**
     * 非延迟依赖注入
     * */
    @Autowired
    private User user;

    /**
     * 延迟依赖注入方法一
     * */
    @Autowired
    private ObjectFactory<User> userObjectFactory;

    /**
     * 延迟依赖注入方法二
     * (推荐用这种方式实现延迟注入，因为它能够减少或者避免一些异常，
     * 比如NoSuchBeanDefinitionException, NoUniqueBeanException)
     * */
    @Autowired
    private ObjectProvider<User> userObjectProvider;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyDependencyInject.class);
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class).getBeanDefinition();
        applicationContext.registerBeanDefinition("user", beanDefinition);
        applicationContext.refresh();

        LazyDependencyInject bean = applicationContext.getBean(LazyDependencyInject.class);

        ObjectFactory<User> userObjectFactory = bean.userObjectFactory;
        System.out.println(userObjectFactory.getObject());

        ObjectProvider<User> userObjectProvider = bean.userObjectProvider;
        User user = userObjectProvider.getObject();
        System.out.println(user);

        applicationContext.close();
    }
}