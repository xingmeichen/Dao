package com.dao.spring.base.annotation;

import com.dao.spring.base.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-15 17:08
 **/
@Component
public class ComponentAnnotationDemo {

    @Autowired
    private User user;

    @Bean
    public User user() {
        return User.createUser();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentAnnotationDemo.class);
        context.refresh();

        ComponentAnnotationDemo bean = context.getBean(ComponentAnnotationDemo.class);
        System.out.println(bean.user == bean.user()); // 结果为false说明 User实例在应用上下文中不是全局唯一的

        context.close();
    }
}