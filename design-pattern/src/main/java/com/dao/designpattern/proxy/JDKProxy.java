package com.dao.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author Mabel
 */
public class JDKProxy implements InvocationHandler {

    private Object targetObject;

    public JDKProxy() {}

    public JDKProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getTargetObject(Object targetObject) {
        // targetObject必须明确指定（不能为null）,否则抛出异常
        Objects.requireNonNull(targetObject, "Target object cannot be null");
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在这里添加增强的前置代码");
        System.out.println("Before invoke " + method.getName());
        Object object = method.invoke(targetObject, args);
        System.out.println("After invoke " + method.getName());
        System.out.println("在这里添加增强的后置代码");
        System.out.println("**********************  The end of the invoke ************************");
        return object;
    }

    public static void main(String[] args) {
        JDKProxy JDKProxy = new JDKProxy();
        Person targetObject = (Person) JDKProxy.getTargetObject(new Teacher());
        // 下面这行代码执行时候会报错，表明了 JDK动态代理是针对实现了接口类生成代理，而不能针对没有实现接口的类。
//        Teacher teacher = (Teacher) JDKProxy.getTargetObject(new Teacher());
        targetObject.task();
        targetObject.greetingWithName("Mabel");
    }
}

