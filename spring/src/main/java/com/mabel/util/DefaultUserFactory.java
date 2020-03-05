package com.mabel.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 17:18
 **/
public class DefaultUserFactory implements IUserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("基于@PostConstruct注解的初始化：IUserFactory初始化中......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean接口的afterPropertiesSet()方法：IUserFactory初始化中......");
    }

    public void customInit() {
        System.out.println("自定义初始化方法：IUserFactory初始化中......");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("基于@PreDestroy的销毁方法：IUserFactory销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("基于@PreDestroy的销毁方法：IUserFactory销毁中...");
    }

    public void customDestroy() {
        System.out.println("自定义销毁方法：IUserFactory销毁中...");
    }
}