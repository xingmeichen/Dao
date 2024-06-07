package com.dao.spring.base.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @project:
 * @description: 环境对象示例
 * @author: Mabel.Chen
 * @create: 2020/8/11
 **/
public class EnvironmentDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        Environment environment = context.getBean(Environment.class);
        System.out.println(environment.toString());

        context.close();
    }
}
