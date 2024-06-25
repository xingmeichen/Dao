package com.dao.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-25
 **/
public class ReflectionDemo {

    public void fun1() {
        System.out.println("In ReflectionDemo#fun1");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectionDemo demo = new ReflectionDemo();
        Object obj = demo;
        Method method = obj.getClass().getMethod("fun1", null);
        if (null != method) {
            method.invoke(obj, null);
        }
    }
}