package com.dao.spring.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project:
 * @description:
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 * @author: Mabel.Chen
 * @create: 2020/8/11
 **/
public class AutowiredAnnotationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        ApplicationContext context = new AnnotationConfigApplicationContext();
    }
}
