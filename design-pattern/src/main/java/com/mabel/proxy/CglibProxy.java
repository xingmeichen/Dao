package com.mabel.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke " + method);
        // 注意这里是调用的 MethodProxy#invokeSuper(), 而不是 MethodProxy#invoke(),
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After invoke " + method);
        return result;
    }

    public void greetingWithName(String name) {
        System.out.println("Hello, nice to meet you. My name is " + name);
    }

    private void greeting() {
        System.out.println("Hello, nice to meet you.");
    }

    public static CglibProxy getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibProxy.class);
        enhancer.setCallback(new CglibProxy());
        return (CglibProxy) enhancer.create();
    }

    public static void main(String[] args) {
        CglibProxy proxy = getProxy();
        proxy.greeting();
        proxy.greetingWithName("Mabel");
    }
}
