package com.mabel.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-05-10 09:36
 **/
@Aspect
@Component
public class MabelAspect {

    @Pointcut("execution(public * com.mabel..*.*(..)) && @annotation(com.mabel.aop.MabelAop)")
    public void mabelPointcut() {
        System.out.println("什么也不做吗？");
    }

    @Before("mabelPointcut()")
    public void beforeWeave() {
        System.out.println("在切点之前执行");
    }

    @Around("mabelPointcut()")
    public Object aroundWeave(ProceedingJoinPoint joinPoint) {
        Object object = null;
        System.out.println("在切点之间执行");
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

    @After("mabelPointcut()")
    public void afterWeave() {
        System.out.println("在切点之后执行");
    }
}