package com.dao.event.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @project:
 * @description: 基于Spring 注解的事件监听器
 * @author: Mabel.Chen
 * @create: 2020/7/26
 **/
@EnableAsync // 允许异步方法调用
public class BaseAnnotationListener {

    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("@EventListener listen ApplicationEvent");
    }

    @EventListener
    public void onApplicationEvent(MabelEvent event) {
        System.out.println("@EventListener listen MabelEvent");
    }

    @EventListener
    @Order(2) // order的数字越小优先级越高
    public void onApplicationEvent(ApplicationContextEvent event) {
        System.out.println("@EventListener(onApplicationEvent) listen ApplicationContextEvent");
    }

    @EventListener
    @Order(1)
    public void onApplicationEvent1(ApplicationContextEvent event) {
        System.out.println("@EventListener(onApplicationEvent1) listen ApplicationContextEvent");
    }

    /**
     * 异步事件监听
     * */
    @EventListener
    @Async // 需要在累上添加 @EnableAsync 使其生效
    public void onApplication(ContextRefreshedEvent event) {
        System.out.println("@EventListener(@Async) listen ContextRefreshedEvent");
    }

    @EventListener
    public void onApplication(ContextStartedEvent event) {
        System.out.println("@EventListener listen ContextStartedEvent");
    }

    @EventListener
    public void onApplication(ContextClosedEvent event) {
        System.out.println("@EventListener listen ContextClosedEvent");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BaseAnnotationListener.class);
        applicationContext.refresh();
        applicationContext.publishEvent(new MabelEvent(""));
        applicationContext.close();
    }
}
