package com.mabel.ioc.bean.dependency.circular;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @project: JavaLearning
 * @description: 循环引用（循环依赖）示例
 * @author: Mabel.Chen
 * @create: 2020-08-15 19:32
 **/
public class CircularReferencesDemo {

    @Bean
    public Student student() {
        Student student = new Student();
        student.setNumber("S001");
        return student;
    }

    @Bean
    public Subject subject() {
        Subject subject = new Subject();
        subject.setName("Sub-001");
        return subject;
    }

    public static void disableCircularReference() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CircularReferencesDemo.class);

        /**
         * 设置false, 会报异常信息如下(默认值为true)：
         * Exception in thread "main" org.springframework.beans.factory.UnsatisfiedDependencyException:
         * Error creating bean with name 'student':
         * Unsatisfied dependency expressed through field 'subjects';
         * nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException:
         * Error creating bean with name 'subject':
         * Unsatisfied dependency expressed through field 'students';
         * nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException:
         * Error creating bean with name 'student':
         * Requested bean is currently in creation: Is there an unresolvable circular reference?
         * **/
        context.setAllowCircularReferences(false);
        // context.setAllowCircularReferences(true);

        context.refresh();
        context.close();
    }

    /**
     * Spring 为什么不用二级缓存二是用三级缓存解决循环依赖的问题?
     */
    public static void why3ClassCache() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CircularReferencesDemo.class);
        context.register(AopProxy.class);
        context.register(LoginService.class);
        context.setAllowCircularReferences(true); // 事实上，默认值是true，这个设置是多余的
        context.refresh();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        LoginService bean1 = beanFactory.getBean(LoginService.class);
        LoginService bean2 = beanFactory.getBean(LoginService.class);
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean1 == bean2); // true

        context.close();
    }

    public static void main(String[] args) {
        why3ClassCache();
    }
}