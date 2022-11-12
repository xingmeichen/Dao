package com.dao.singleton;

/**
 * @project: JavaLearning
 * @description:
 * 懒汉式：懒加载
 *
 * @author: Mabel.Chen
 * @create: 2022-03-17
 **/
public class Singleton2 {

    public volatile static Singleton2 instance = null;

    private Singleton2() {

    }

    /***
     *  双重锁校验机制
     * */
    public static Singleton2 getInstance() {
        if (null == instance) {
            synchronized (Singleton2.class) {
                if (null == instance) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

    public static synchronized Singleton2 getInstanceV2() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}