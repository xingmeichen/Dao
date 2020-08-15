package com.mabel.event.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @project:
 * @description:
 * @author: Mabel.Chen
 * @create: 2020/7/26
 **/
public class MabelApplicationListener implements ApplicationListener<MabelEvent> {

    @Override
    public void onApplicationEvent(MabelEvent event) {
        System.out.println("MabelApplicationListener is listening " + event.getClass().getSimpleName() + " event");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MabelApplicationListener.class);
        applicationContext.refresh();
        MabelApplicationListener listener = applicationContext.getBean(MabelApplicationListener.class);
        System.out.println(listener);
        // 因为 AnnotationConfigApplicationContext 实现了 ApplicationEventPublisher，所以可以通过它来发布事件
        applicationContext.publishEvent(new MabelEvent("MabelEvent"));
        applicationContext.close();
    }
}
