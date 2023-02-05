package com.dao.singleton;

/**
 * @project: Dao
 * @description:
 * 静态内部类实现
 * @author: Mabel.Chen
 * @create: 2022-03-17
 **/
public class Singleton3 {

    public Singleton3 instance;

    public static class Instance {
        public static final Singleton3 instance = new Singleton3();
    }

    public Singleton3 getInstance() {
        return Instance.instance;
    }
}