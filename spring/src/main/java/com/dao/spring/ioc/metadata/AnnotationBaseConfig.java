package com.dao.spring.ioc.metadata;

import com.dao.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @project: Dao
 * @description: 基于Java注解的元数据配置
 * @author: Mabel.Chen
 * @create: 2020-02-14 15:34
 **/
@Configuration
public class AnnotationBaseConfig {

    @Autowired
    private User user;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        getDetailOfMetaData(applicationContext);
        applicationContext.register(AnnotationBaseConfig.class);
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
        applicationContext.close();
    }

    @Bean
    @Qualifier("user")
    public User createUser() {
        User user = new User();
        user.setId(10000L).setName("Mabel");
        return user;
    }

    public static void getDetailOfMetaData(AnnotationConfigApplicationContext applicationContext) {
        if (null == applicationContext) {
            return;
        }
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        String[] beanNamesForAutowired = beanFactory.getBeanNamesForAnnotation(Autowired.class);
        if (null != beanNamesForAutowired) {
            for (String beanName : beanNamesForAutowired) {
                System.out.println(beanName);
            }
        }
        String[] beanNamesForConfiguration = beanFactory.getBeanNamesForAnnotation(Configuration.class);
        if (null != beanNamesForConfiguration) {
            for (String beanName : beanNamesForConfiguration) {
                System.out.println(beanName);
            }
        }
    }
}