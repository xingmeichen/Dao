package com.dao.algorithm.base.adapter;

/**
 * @project: Dao
 * @description: 适配器模式的调用
 * @author: Mabel.Chen
 * @create: 2021-11-20 10:28
 **/
public class Client {

    public static void main(String[] args) {
        /***
         * 我现在想要调用 {@link OldInterface#doWork()}，
         * 但是，doWork的具体实现需要跟NewInterface{@link NewInterface#newDoWork()}的一样.
         * 也就是我必须使用 {@link OldInterface} 的 doWork() 这个方法签名，
         * 但是实际上做的事情却是NewInterface它的新的实现
         * 于是我想到了适配器模式
         */
        OldInterface adapter = new Adapter();
        adapter.doWork();

        /***
         * 而同时，旧的 {@link OldInterface#doWork()} 方法依然可以正常调用
         * */
        OldInterface oldInterface = new OldImplement();
        oldInterface.doWork();
    }
}