package com.dao.spring.base.ioc.bean.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @project: Dao
 * @description: Aware接口实现的依赖注入
 * @author: Mabel.Chen
 * @create: 2020-02-15 17:43
 **/
public class AwareInterfaceDependencyInject implements BeanFactoryAware, ApplicationContextAware {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareInterfaceDependencyInject.class);
        applicationContext.refresh();
        AwareInterfaceDependencyInject bean = applicationContext.getBean(AwareInterfaceDependencyInject.class);
        BeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println(beanFactory == bean.beanFactory);
        System.out.println(applicationContext == bean.applicationContext);
        applicationContext.close();
    }
}