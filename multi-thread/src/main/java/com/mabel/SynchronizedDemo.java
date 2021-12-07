package com.mabel;

/**
 * @project: JavaLearning
 * @description:
 * synchronized 关键字示例
 * synchronized 是对对象加锁，而如果是在声明方法上用了该关键字，说明是对当前对象加锁
 * 具体示例如下, 也就是 syn2() 与 syn3()这两种方法的加锁方式是等价的
 * @author: Mabel.Chen
 * @create: 2021-12-06 10:11
 **/
public class SynchronizedDemo {

    public static Integer count;

    public void syn1() {
        synchronized (count) {
            count++;
            System.out.println("syn1 方法");
        }
    }

    public void syn2() {
        synchronized (this) {
            count++;
            System.out.println("syn2 方法");
        }
    }
    /***
     * 相当于 synchronized (this)
     * */
    public synchronized void syn3() {
        count++;
        System.out.println("syn3 方法");
    }

    /***
     * 相当于 synchronized(SynchronizedDemo.class)
     * */
    public synchronized static void synStatic1() {
        count++;
        System.out.println("synStatic1 方法");
    }

    /***
     * 相当于 synchronized(SynchronizedDemo.class)
     * */
    public static void synStatic2() {
        synchronized (SynchronizedDemo.class) {
            count++;
            System.out.println("synStatic2 方法");
        }
    }
}