package com.mabel.singleton;

/**
 * @project: JavaLearning
 * @description:
 * 饿汉式： 非懒加载
 *
 * @author: Mabel.Chen
 * @create: 2021-01-30 16:41
 **/
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton1 instance1 = getInstance();
        Singleton1 instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }
}