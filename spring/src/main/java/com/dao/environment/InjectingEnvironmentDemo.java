package com.dao.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @project:
 * @description: 通过依赖注入获取Environment对象
 * @author: Mabel.Chen
 * @create: 2020/8/10
 **/
public class InjectingEnvironmentDemo implements EnvironmentAware {

    private Environment environment;

    @Autowired
    private Environment environment2;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingEnvironmentDemo.class);
        context.refresh();

        InjectingEnvironmentDemo bean = context.getBean(InjectingEnvironmentDemo.class);
        System.out.println(bean.environment == bean.environment2);

        context.close();
    }
}
