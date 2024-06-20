package com.dao.base.thread.ticket;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-06-30 12:38
 **/
public class TicketCallable implements Callable<Integer> {

    private static final Integer TOTAL = 100;
    private static Integer quantity = TOTAL;

    // 该字段相当于一个锁，因为在run方法中对这个锁同步，所以只有获得该锁的线程才能执行同步代码块
    private static String lock = "lock";

    private String name;
    private Thread thread;

    public TicketCallable(String name) {
        this.name = name;
    }

    public Integer call() throws Exception {
        while (quantity > 0) {
            synchronized (lock) {
                if (quantity > 0) {
                    System.out.println("通过" + this.name + "卖出了第" + quantity + "张票");
                    quantity--;
                } else {
                    System.out.println("票已经卖完");
                }
            }
        }
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void start(FutureTask futureTask) {
        System.out.println("Starting " +  this.name );
        if (thread == null) {
            thread = new Thread(futureTask, this.name);
            thread.start();
        }
    }

    public static void main(String[] args) {
        TicketCallable ticket1 = new TicketCallable("ticket1");
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(ticket1);
        TicketCallable ticket2 = new TicketCallable("ticket2");
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(ticket2);
        TicketCallable ticket3 = new TicketCallable("ticket3");
        FutureTask<Integer> futureTask3 = new FutureTask<Integer>(ticket3);
        try {
            ticket1.start(futureTask1);
            ticket2.start(futureTask2);
            ticket3.start(futureTask3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}