package com.dao.ioc.bean.initiization;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-15 16:12
 **/
public class InitializationDomain implements InitializingBean {

    @PostConstruct
    public void init() {
        System.out.println("基于@PostConstruct注解的初始化：InitializationDomain 初始化中......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean接口的afterPropertiesSet()方法：InitializationDomain 初始化中......");
    }

    public void customInit() {
        System.out.println("自定义初始化方法：InitializationDomain 初始化中......");
    }
}