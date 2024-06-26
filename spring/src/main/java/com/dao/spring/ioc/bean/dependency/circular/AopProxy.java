package com.dao.spring.ioc.bean.dependency.circular;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-09-17 00:02
 **/
@Aspect
@Component
public class AopProxy {

    @Before("execution(* com.dao.spring.ioc.bean.dependency.circular.LoginService.login(..))")
    public void doBefore() {
        System.out.println("execute before");
    }
}