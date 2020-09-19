package com.mabel.ioc.bean.dependency.circular;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-09-17 00:02
 **/
@Aspect
@Component
public class AopProxy {

    @Before("execution(* com.mabel.ioc.bean.dependency.circular.LoginService.login(..))")
    public void deBefore() {
        System.out.println("execute before");
    }
}