package com.mabel.question;

import com.mabel.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-15 16:38
 **/
@Configuration
public class DemoOne {

    @Bean
    @Lazy
    public User user() {
        User user = User.createUser();
        user.setId(1L);
        user.setName("Mabel");
        return user;
    }
}