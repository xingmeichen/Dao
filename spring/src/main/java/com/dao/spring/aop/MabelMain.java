package com.dao.spring.aop;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-05-10 09:54
 **/
@Component
public class MabelMain {

    @MabelAop
    public void testAspect() {
        System.out.println("Hello World");
    }

    public static void loadByXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/aop.xml");
        MabelMain bean = applicationContext.getBean(MabelMain.class);
        bean.testAspect();
    }

    public static void loadByAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MabelAspect.class);
        applicationContext.register(MabelMain.class);
        // 需要注册 AnnotationAwareAspectJAutoProxyCreator 用于实现AOP
        applicationContext.register(AnnotationAwareAspectJAutoProxyCreator.class);
        applicationContext.refresh();
        MabelMain bean = applicationContext.getBean(MabelMain.class);
        bean.testAspect();
        applicationContext.close();
    }

    public static void main(String[] args) {
        //loadByXml();
        loadByAnnotation();
    }
}