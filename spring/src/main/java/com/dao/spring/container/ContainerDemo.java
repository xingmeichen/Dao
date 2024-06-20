package com.dao.spring.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-03-12
 **/
public class ContainerDemo {

    public void greeting() {
        System.out.println("Hello World");
    }

    public static void loadByXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/aop.xml");
        ContainerDemo bean = applicationContext.getBean(ContainerDemo.class);
        bean.greeting();
    }

    public static void loadByAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ContainerDemo.class);
        applicationContext.refresh();
        ContainerDemo bean = applicationContext.getBean(ContainerDemo.class);
        bean.greeting();
        applicationContext.close();
    }

    public static void main(String[] args) {
        //loadByXml();
        loadByAnnotation();
    }
}