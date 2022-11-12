package com.dao.ioc.container;

import com.dao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 15:13
 **/
@Configuration
public class AnnotationApplicationContextAsIocContainer {

    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIocContainer 作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainer.class);
        applicationContext.refresh();
        lookupColletionByType(applicationContext);
        applicationContext.close();
    }

    public static void lookupColletionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有User类型的对象：");
            beans.forEach((beanName, bean) -> System.out.println(bean));
        }
    }

    /**
     * 通过Java注解的方式注入Bean
     * */
    @Bean
    public User createUser() {
        User user = new User();
        user.setId(10000L);
        user.setName("Mabel");
        return user;
    }
}