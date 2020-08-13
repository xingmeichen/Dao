package com.mabel.annotation;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @project:
 * @description: {@link Value } @Value 注解示例, 如下是可追踪其原理的相关类或者方法
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 * @see AutowiredAnnotationBeanPostProcessor#postProcessProperties -->
 * @see InjectionMetadata#inject -->
 * @see AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement#inject -->
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency -->
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#doResolveDependency -->
 * @see org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver#getSuggestedValue
 * @see org.springframework.core.convert.ConversionService
 * @see org.springframework.core.convert.support.DefaultConversionService (ConversionService的其中一个具体实现类)
 * @author: Mabel.Chen
 * @create: 2020/8/11
 **/
public class ValueAnnotationDemo {

    @Value("${user.name}") // 这个是环境变量，所以不需要手动配置
    private String userName;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ValueAnnotationDemo.class);
        context.refresh();

        ValueAnnotationDemo bean = context.getBean(ValueAnnotationDemo.class);
        System.out.println(bean.userName);

        context.close();
    }
}
