package com.dao.spring.ioc.bean.initiization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @project: Dao
 * @description: Bean的初始化示例
 * @author: Mabel.Chen
 * @create: 2020-02-15 15:12
 **/
@Configuration
public class BeanInitialization {

    @Autowired
    private InitializationDomain initializationDomain;
    /**
     * 这里演示了三种Bean初始化的方法：
     * 输出结果是：
     * 基于@PostConstruct注解的初始化：InitializationDomain 初始化中......
     * 实现InitializingBean接口的afterPropertiesSet()方法：InitializationDomain 初始化中......
     * 自定义初始化方法：InitializationDomain 初始化中......
     *
     * 从结果中也可以看出三种方式的优先级
     * */
    public static void main(String[] args) {
        notLazyInit();
        lazyInit();
    }

    /**
     *  延迟初始化：
     *  输出结果：
     *  （1）不调用getBean的情况下（没有A行代码）输出：
     *  应用上下文已启动...
     *
     *  （2）调用getBean情况下（有A行代码））输出
     *   应用上下文已启动...
     *   基于@PostConstruct注解的初始化：InitializationDomain 初始化中......
     *   实现InitializingBean接口的afterPropertiesSet()方法：InitializationDomain 初始化中......
     *   自定义初始化方法：InitializationDomain 初始化中......
     *
     *
     *  也就是说它只有在去使用Bean的时候才会调用初始化方法
     * */
    public static void lazyInit() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitialization.class);
        applicationContext.refresh();
        System.out.println("应用上下文已启动...");
        BeanInitialization bean = applicationContext.getBean(BeanInitialization.class);
        InitializationDomain initializationDomain = applicationContext.getBean(InitializationDomain.class); // A
        InitializationDomain initializationDomain1 = bean.initializationDomain;
        System.out.println("initializationDomain == initializationDomain1 ? " + (initializationDomain == initializationDomain1));
        applicationContext.close();
    }

    /**
     * 非延迟初始化时，在应用上下文启动完成后Bean被初始化
     * 输出结果：
     * 基于@PostConstruct注解的初始化：InitializationDomain 初始化中......
     * 实现InitializingBean接口的afterPropertiesSet()方法：InitializationDomain 初始化中......
     * 自定义初始化方法：InitializationDomain 初始化中......
     * 应用上下文已启动...
     * */
    public static void notLazyInit() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitialization.class);
        applicationContext.refresh();
        System.out.println("应用上下文已启动...");
        applicationContext.close();
    }

    @Bean(initMethod = "customInit")
    @Lazy // 表示延迟初始化
    public InitializationDomain initializationDomain() {
        return new InitializationDomain();
    }
}