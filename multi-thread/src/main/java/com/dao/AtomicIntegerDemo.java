package com.dao;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: Dao
 * @description: 证明 AtomicXX 比synchronized快
 * @author: Mabel.Chen
 * @create: 2020-09-19 19:23
 **/
public class AtomicIntegerDemo {

    private AtomicInteger count = new AtomicInteger(0);

    public void atomicIncrement() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            count.incrementAndGet();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public synchronized void syncIncrement() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000;) {
            i++;
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        demo.atomicIncrement();
        demo.syncIncrement();
    }
}