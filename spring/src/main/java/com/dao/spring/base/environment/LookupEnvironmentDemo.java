package com.dao.spring.base.environment;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @project:
 * @description: 通过依赖查找Environment对象
 * @author: Mabel.Chen
 * @create: 2020/8/10
 **/
public class LookupEnvironmentDemo implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LookupEnvironmentDemo.class);
        context.refresh();

        Environment environment = context.getBean(Environment.class);
        LookupEnvironmentDemo bean = context.getBean(LookupEnvironmentDemo.class);
        System.out.println(environment == bean.environment);

        context.close();
    }
}
