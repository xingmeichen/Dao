package com.dao.base.thread;

import java.util.concurrent.Semaphore;

/**
 * @project: Dao
 * @description:
 * @see {@link Semaphore} 示例
 * 使用场景：限流，限制同时只能有设定数量的线程在运行
 * @author: Mabel.Chen
 * @create: 2021-12-06 21:57
 **/
public class SemaphoreDemo {

    Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        //TODO

        Thread t = new Thread();
        System.out.println("Thread ID: " + t.getId());
        System.out.println("Thread name: " + t.getName());
        System.out.println();
    }
}