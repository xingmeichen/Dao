package com.mabel.aop;

import org.springframework.context.ApplicationContext;
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

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/aop.xml");
        MabelTest bean = applicationContext.getBean(MabelTest.class);
        bean.testAspect();
    }
}