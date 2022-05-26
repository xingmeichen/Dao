package com.mabel;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-05-23
 **/
public class MainTest extends Thread {

    @Override
    public void run() {
        int i = 0;
        for (; i < 100; i++) {
        }
        System.out.println(Thread.currentThread().getName() + ": " + i);
    }

    public static void main(String[] args) {
        MainTest t1 = new MainTest();
        MainTest t2 = new MainTest();
        t1.start();
        t2.start();
    }
}