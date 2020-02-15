package ioc.metadata;

import domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @project: JavaLearning
 * @description: 基于Java注解的元数据配置
 * @author: Mabel.Chen
 * @create: 2020-02-14 15:34
 **/
@Configuration
public class AnnotationBaseConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationBaseConfig.class);
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
        applicationContext.close();
    }

    @Bean
    public User createUser() {
        User user = new User();
        user.setId(10000L).setName("Mabel");
        return user;
    }
}