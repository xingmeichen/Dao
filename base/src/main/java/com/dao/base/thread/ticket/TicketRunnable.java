package com.dao.base.thread.ticket;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-06-30 12:13
 **/
public class TicketRunnable implements Runnable {

    private static final Integer TOTAL = 50;
    private static Integer quantity = TOTAL;

    // 该字段相当与一个锁，因为在run方法中对这个锁同步，所以只有获得该锁的线程才能执行同步代码块
    private static String lock = "lock";

    private String name;
    private Thread thread;

    public TicketRunnable(String name) {
        this.name = name;
    }

    public void run() {
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
    }

    public void start() {
        System.out.println("Starting " +  this.name );
        if (thread == null) {
            thread = new Thread(this, this.name);
            thread.start();
        }
    }

    public static void main(String[] args) {
        TicketRunnable ticket1 = new TicketRunnable("ticket1");
        TicketRunnable ticket2 = new TicketRunnable("ticket2");
        TicketRunnable ticket3 = new TicketRunnable("ticket3");
        ticket1.start();
        ticket2.start();
        ticket3.start();
        ticket1.run();
    }
}