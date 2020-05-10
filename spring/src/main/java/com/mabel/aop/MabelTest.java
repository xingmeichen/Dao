package com.mabel.aop;

import com.mabel.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.applet.AppletContext;

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
        Object user = applicationContext.getBean(User.class);
        MabelTest bean = applicationContext.getBean(MabelTest.class);
        System.out.println(user);
        bean.testAspect();
    }
}