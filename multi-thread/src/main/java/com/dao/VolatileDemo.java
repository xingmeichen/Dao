package com.dao;

/**
 * @project: Dao
 * @description: 证明 volatile 的可见性
 * @author: Mabel.Chen
 * @create: 2020-09-19 18:40
 **/
public class VolatileDemo extends Thread {

    private static volatile boolean running = true;

    public void running() {
        System.out.println("I am starting");
        while (running) {
            // do nothing
        }
        System.out.println("I am finished");
    }

    public static void main(String[] args) throws Exception {
        // 如果volatile不可见，那么running方法将永远执行下去
        new Thread(new VolatileDemo()::running, "demo1").start();
        Thread.sleep(5000);
        running = false;
    }
}