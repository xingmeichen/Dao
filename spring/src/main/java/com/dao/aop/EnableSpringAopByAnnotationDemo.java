package com.dao.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-03-16
 **/
@EnableAspectJAutoProxy(exposeProxy = true)
public class EnableSpringAopByAnnotationDemo {

    @MabelAop
    public void testMabelAop() {
        System.out.println("This is a test for Mabel AOP");
    }

    @MabelAop
    public void testCallInTheSameClass() {
        System.out.println("test: call in the same class");
        testMabelAop(); // 这个方法这样调用并不会被拦截，因为这里相当于 this.testMabelAop(), this引用不是代理对象
    }

    @MabelAop
    public void testCallInTheSameClassByProxy() {
        System.out.println("test: call in the same class by proxy");
        // 这里为了能获得代理类，必须将 exposeProxy 设置为 true, 也就是 @EnableAspectJAutoProxy(exposeProxy = true)
        ((EnableSpringAopByAnnotationDemo) AopContext.currentProxy()).testMabelAop();
    }

    /***
     * protected作用域方法不会被拦截
     */
    @MabelAop
    protected void testProtected() {
        System.out.println("Test protected");
    }

    /***
     * 私有方法不会被拦截
     */
    @MabelAop
    private void testPrivate() {
        System.out.println("Test private");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableSpringAopByAnnotationDemo.class);
        context.register(MabelAspect.class);
        context.refresh();
        EnableSpringAopByAnnotationDemo bean = context.getBean(EnableSpringAopByAnnotationDemo.class);
        bean.testMabelAop();
        bean.testProtected();
        bean.testPrivate();
        bean.testCallInTheSameClass();
        bean.testCallInTheSameClassByProxy();
        context.close();
    }
}