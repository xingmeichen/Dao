package com.dao.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @project: JavaLearning
 * @description: 拦截器示例
 * @author: Mabel.Chen
 * @create: 2021-01-09 14:14
 **/
public class AopInterceptorDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    long start = System.currentTimeMillis();
                    EchoService echoService;
                    try {
                        echoService = new DefaultEchoService();
                    } finally {
                        long end = System.currentTimeMillis();
                        System.out.println("echo方法执行的时间：" + (end - start) + "毫秒");
                    }
                    return echoService.echo((String) args[0]);
                }
                return null;
            }
        });
        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello world");
    }
}