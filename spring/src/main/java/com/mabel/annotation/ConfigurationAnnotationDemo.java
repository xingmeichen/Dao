package com.mabel.annotation;

import com.mabel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-15 17:04
 **/
@Configuration
public class ConfigurationAnnotationDemo {

    @Autowired
    private User user;

    @Bean
    @Scope(value = "singleton")
    public User user() {
        return User.createUser();
    }

    @Bean
    @Scope(value = "prototype")
    public User prototypeUser() {
        return User.createUser();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigurationAnnotationDemo.class);
        context.refresh();

        ConfigurationAnnotationDemo bean = context.getBean(ConfigurationAnnotationDemo.class);
        System.out.println(bean.user == bean.user()); // 结果为true说明 User实例在应用上下文中是全局唯一的
        System.out.println(bean.user == bean.prototypeUser());
        context.close();
    }
}