package com.dao.spring.base.aop;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-12-26 15:07
 **/
public class ClassLoading {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        while (true) {
            ClassLoader parentClassLoader = classLoader.getParent();
            if (null == parentClassLoader) {
                break;
            }
            classLoader = parentClassLoader;
            System.out.println(classLoader);
        }
    }
}