package com.mabel.aop;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-05-10 09:54
 **/
@Component
public class MabelTest {

    @MabelAop
    public void testAspect() {
        System.out.println("Hello World");
    }

    public static void loadByXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/aop.xml");
        MabelTest bean = applicationContext.getBean(MabelTest.class);
        bean.testAspect();
    }

    public static void loadByAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MabelAspect.class);
        applicationContext.register(MabelTest.class);
        applicationContext.register(AnnotationAwareAspectJAutoProxyCreator.class);
        applicationContext.refresh();
        MabelTest bean = applicationContext.getBean(MabelTest.class);
        bean.testAspect();
        applicationContext.close();
    }

    public static void main(String[] args) {
        loadByXml();
        loadByAnnotation();
    }
}