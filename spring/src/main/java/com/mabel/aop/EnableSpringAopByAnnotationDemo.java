package com.mabel.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-03-16
 **/
@EnableAspectJAutoProxy
public class EnableSpringAopByAnnotationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableSpringAopByAnnotationDemo.class);
        context.refresh();
        EnableSpringAopByAnnotationDemo bean = context.getBean(EnableSpringAopByAnnotationDemo.class);
        System.out.println(bean);
        context.close();
    }
}