package com.dao.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-08-09 14:45
 **/
@EnableAsync // 激活Spring异步特性
public class AnnotatedAsyncEventHandlerDemo {

    @Async // 异步事件监听 (默认情况下，也就是没有添加这个注解的时候是同步)
    @EventListener // 通过注解实现事件监听
    public void onEvent(MabelEvent event) {
        System.out.println("I am saying: " + event.getMessage());
    }

    @Bean
    public Executor taskExecutor() {
        ExecutorService taskExecutor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("spring-event-thread-pool"));
        return taskExecutor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MabelEventListener.class);
        applicationContext.register(AnnotatedAsyncEventHandlerDemo.class);
        applicationContext.refresh();
        applicationContext.publishEvent(new MabelEvent(new Object(), "Nice to meet you."));
        applicationContext.close();
    }
}