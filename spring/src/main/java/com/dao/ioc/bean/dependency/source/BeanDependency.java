package com.dao.ioc.bean.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @project: Dao
 * @description: Bean 依赖
 * 该示例说明，依赖查找和依赖注入的依赖来源是不同的，
 * 依赖注入的依赖来源会比依赖查找的来源多一个ResolvableDependency (非Spring容器管理对象)
 * @author: Mabel.Chen
 * @create: 2020-02-13 11:19
 **/
public class BeanDependency {

    /***
     *  @Autowired 注入在 postProcessProperty方法执行，早于setter注入，也早于@PostConstruct注入
     * */
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 后面的三个都为true, 具体是因为 AbstractApplicationContext#prepareBeanFactory 在这个方法中，
     * 注入的三个类型 ApplicationContext  ApplicationEventPublisher ResourceLoader，其值都是当前上下文（this）
     * */
    @PostConstruct
    public void initByInjection() {
        // false
        System.out.println("beanFactory == applicationContext ? " + (beanFactory == applicationContext));
        // true
        System.out.println("beanFactory == applicationContext.getBeanFactory ? " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        // true
        System.out.println("applicationEventPublisher == applicationContext ? " + (applicationEventPublisher == applicationContext));
        // true
        System.out.println("resourceLoader == applicationContext ? " + (resourceLoader == applicationContext));
    }

    @PostConstruct
    public void initByLookup() {
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ApplicationEventPublisher.class);
        getBean(ResourceLoader.class);
    }


    private <T> T getBean(Class<T> beanType) {
        try {
            return beanFactory.getBean(beanType);
        } catch (Exception e) {
            System.err.println("当前类型 " + beanType.getName() + " 无法在BeanFactory中查找");
            return null;
        }
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanDependency.class);
        annotationConfigApplicationContext.refresh();

        // 该语句会报 NoSuchBeanDefinitionException 异常
//        BeanFactory bean = annotationConfigApplicationContext.getBean(BeanFactory.class);
//        System.out.println(bean);


        annotationConfigApplicationContext.close();
    }

}