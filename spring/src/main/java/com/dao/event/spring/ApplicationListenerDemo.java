package com.dao.event.spring;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @project:
 * @description:
 * @author: Mabel.Chen
 * @create: 2020/6/21
 **/
public class ApplicationListenerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        /**
         * 基于 ConfigurableApplicationContext API实现
         * */
        context.addApplicationListener(applicationEvent -> System.out.println("收到 Spring 事件" + applicationEvent));
        context.addApplicationListener(new MabelApplicationListener());
        context.refresh();
        context.close();
    }
}
