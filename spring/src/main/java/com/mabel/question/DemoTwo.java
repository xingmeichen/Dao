package com.mabel.question;

import com.mabel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-15 16:39
 **/
@Configuration
public class DemoTwo {

    @Autowired
    private User user;

    @Bean
    public User user() {
        User user = User.createUser();
        user.setId(1L);
        user.setName("Mabel");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DemoOne.class);
        context.register(DemoTwo.class);
        context.refresh();

        DemoOne demoOne = context.getBean(DemoOne.class);
        DemoTwo demoTwo = context.getBean(DemoTwo.class);
        User user1 = demoOne.user();
        User user2 = demoTwo.user();
        System.out.println(user1 == user2);
        System.out.println(demoTwo.user == user2);
        System.out.println("user1 : " + user1);
        System.out.println("user2 : " + user2);
        context.close();
    }
}