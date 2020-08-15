package com.mabel.event;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-09 14:34
 **/
public class EventListenMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册监听器
        applicationContext.register(SecondEventListener.class);
        applicationContext.register(MabelEventListener.class);
        applicationContext.refresh();
        // 发布事件
        applicationContext.publishEvent(new MabelEvent("", "Hello, this is Mabel, May I help you?"));
        applicationContext.close();
    }
}