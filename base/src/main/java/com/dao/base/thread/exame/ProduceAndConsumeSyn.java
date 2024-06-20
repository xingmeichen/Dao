package com.dao.base.thread.exame;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Dao
 * @description: 写一个固定容量同步容器，拥有put 和 get 方法，以及 getCount 方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用。
 *
 * 在给类中用synchronized 实现
 *
 * Java中现有的实现
 * @see {@link java.util.concurrent.LinkedBlockingDeque}
 *
 * @author: Mabel.Chen
 * @create: 2021-12-08 08:35
 **/
public class ProduceAndConsumeSyn {

    private List<String> list = new ArrayList<>();
    private final int MAX_SIZE = 10;

    public synchronized boolean put(String item) {
        try {
            while (MAX_SIZE == getCount()) {
                this.wait();
            }
            list.add(item);
            System.out.println(Thread.currentThread().getName() + " produces " + item);
            this.notifyAll();
            return true;
        } catch (InterruptedException e) {
            System.out.println("produce error: " +e.getMessage());
            return false;
        }
    }

    public synchronized String get() {
        try {
            while (0 == getCount()) {
                this.wait();
            }
            String item = list.remove(0);
            System.out.println(Thread.currentThread().getName() + " consumes " + item);
            this.notifyAll();
            return item;
        } catch (InterruptedException e) {
            System.out.println("consume error: " +e.getMessage());
            return null;
        }
    }

    public synchronized int getCount() {
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println("Application starts...");

        ProduceAndConsumeSyn syn = new ProduceAndConsumeSyn();

        for (int i = 1; i <= 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    syn.get();
                }
            }, "Consumer_" + i).start();
        }

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    syn.put("Item_" + finalI + "_" + j);
                }
            }, "Producer_" + i).start();
        }

        System.out.println("Application ends...");
    }
}