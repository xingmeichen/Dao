package com.dao.spring.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @project: Dao
 * @description:  这是一个切面
 * @author: Mabel.Chen
 * @create: 2020-05-10 09:36
 **/
@Aspect
@Component
public class MabelAspect {

    /**
     * 定义切点 （也叫切入点 Pointcut）
     * */
    @Pointcut("execution(public * com.dao..*.*(..)) && @annotation(com.dao.aop.MabelAop)")
//    @Pointcut("@annotation(com.dao.aop.MabelAop)")
    public void mabelPointcut() {
        System.out.println("什么也不做吗？");
    }

    /**
     * 定义环绕通知, 环绕通知最先执行
     * */
    @Around("mabelPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object object = null;
        System.out.println("在切点之间执行");
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

    /**
     * 定义前置通知
     * */
    @Before("mabelPointcut()")
    public void beforeAdvice() {
        System.out.println("在切点之前执行");
    }

    /**
     * 定义后置通知
     * */
    @After("mabelPointcut()")
    public void afterAdvice() {
        System.out.println("在切点之后执行");
    }
}