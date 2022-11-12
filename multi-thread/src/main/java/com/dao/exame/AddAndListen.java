package com.dao.exame;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: JavaLearning
 * @description:
 *  1. 实现一个容器，提供两个方法，add, size
 *  写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 *  注意的问题：
 *  1. 如何保证线程1优先于线程2运行
 *  2. 如何保证当元素容器到5之后，线程2运行，然后线程1再次执行直到线程死亡
 *  (如果处理不好，会出现线程1运行结束之后线程2才运行到情况；也会出现线程2在元素数量是其他任意数值而不是5的时候执行然后结束)
 * @author: Mabel.Chen
 * @create: 2021-12-07 19:30
 **/
public class AddAndListen {

    private static Set<Integer> set = new HashSet<>();
    private static int size;
    private static Object lock = new Object();

    private static Thread addThread = null;
    private static Thread listenThread = null;

    public synchronized static int size() {
        return set.size();
    }

    public synchronized static boolean add(Integer element) {
        set.add(element);
        size++;
        return true;
    }

    public static void main(String[] args)  {

        listenThread = new Thread(() -> {
            try {
                synchronized (lock) {
                    if (5 != size()) {
                        lock.wait();
                    }
                    System.out.println("The container has 5 elements, listen thread ends");
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        addThread = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 1; i <= 10; i++) {
                        add(i);
                        System.out.println("Add " + i);
                        if (5 == size()) {
                            lock.notify();
                            lock.wait();
                        }
                        if (1 == size()) {
                            // 在这里才start 监听线程是为了保证添加元素的线程先执行
                            listenThread.start();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        addThread.start();
        try {
            addThread.join();
            listenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 加上这两个线程的join是保证下面这句话最后输出
        System.out.println("Execution ends");
    }
}