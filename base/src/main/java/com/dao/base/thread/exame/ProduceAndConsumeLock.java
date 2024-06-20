package com.dao.base.thread.exame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Dao
 * @description: 写一个固定容量同步容器，拥有put 和 get 方法，以及 getCount 方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用。
 *
 * 在给类中用Lock 实现
 *
 * Java中现有的实现
 * @see {@link java.util.concurrent.LinkedBlockingDeque}
 *
 * @author: Mabel.Chen
 * @create: 2021-12-08 08:35
 **/
public class ProduceAndConsumeLock {

    private List<String> list = new ArrayList<>();
    private final int MAX_SIZE = 10;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public boolean put(String item) {
        try {
            lock.lock();
            while (getCount() == MAX_SIZE) {
                producer.await();
            }
            list.add(item);
            System.out.println(Thread.currentThread().getName() + " produces " + item);
            consumer.signalAll();
            return true;
        } catch (Exception e) {
            System.out.println("produce error: " + e.getMessage());
            return false;
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        try {
            lock.lock();
            while (getCount() == 0) {
                consumer.await();
            }
            String item = list.remove(0);
            System.out.println(Thread.currentThread().getName() + " consumes " + item);
            producer.signalAll();
            return item;
        } catch (Exception e) {
            System.out.println("consume error: " + e.getMessage());
            return null;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        try {
            lock.lock();
            return list.size();
        } catch (Exception e) {
            System.out.println("get count error: " + e.getMessage());
            return -1;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println("Application starts...");
        ProduceAndConsumeLock container = new ProduceAndConsumeLock();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    container.get();
                }
            }, "Consumer_" + i).start();
        }

        for (int i = 1; i <= 2; i++) {
            int index = i;
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    container.put("Item_" + index + "_" + j);
                }
            }, "Producer_" + i).start();
        }

        System.out.println("Application ends...");
    }
}