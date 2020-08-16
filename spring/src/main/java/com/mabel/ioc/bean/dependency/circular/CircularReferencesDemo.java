package com.mabel.ioc.bean.dependency.circular;

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

    public static void main(String[] args) {
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
}