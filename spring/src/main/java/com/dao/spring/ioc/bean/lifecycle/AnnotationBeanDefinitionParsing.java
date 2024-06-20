package com.dao.spring.ioc.bean.lifecycle;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-03-08 11:56
 **/
public class AnnotationBeanDefinitionParsing {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        // 注册当前类 AnnotationBeanDefinitionParsing
        reader.register(AnnotationBeanDefinitionParsing.class);
        AnnotationBeanDefinitionParsing bean = beanFactory.getBean(AnnotationBeanDefinitionParsing.class);
        System.out.println(bean);

        AnnotationBeanDefinitionParsing bean1 = (AnnotationBeanDefinitionParsing) beanFactory.getBean("annotationBeanDefinitionParsing");

        System.out.println(bean1);

        /**
         * bean == bean1 结果为true说明的问题
         * 1、通过注解的方式注册Bean是Singleton 的作用域
         * 2、这册的Bean的名称是类名的的一个字符小写，它是通过 {@link BeanNameGenerator } 实现的,
         *    具体实现是 {@link AnnotationBeanNameGenerator}
         * */
        System.out.println(bean == bean1);

    }
}