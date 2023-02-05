package com.dao.ticket;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-06-30 11:55
 *
 * reference:
 * https://blog.csdn.net/qq_34996727/article/details/80416277
 **/
public class TicketThread extends Thread {

    private static final Integer TOTAL = 100;
    private static Integer quantity = TOTAL;

    /** 有一个疑问：为什么不能直接对quantity加锁呢？我尝试了对quantity加锁，结果会出现多台机器同时卖同一张票的情况，
        但是既然是锁住了票的数量，为什么还会出现这种情况呢？
     */
    // 该字段相当与一个锁，因为在run方法中对这个锁同步，所以只有获得该锁的线程才能执行同步代码块
    private static String lock = "lock";

    /**
     * 注意，由于String常量池可能对同步带来的问题，所以在大多数情况下，同步synchronized代码块度不使用String作为锁对象，
     * 而改用其他，比如可以用直接用 Object
     *
     * 由于String常量池的问题，让我联想到，为什么不直接对quantity加锁，极有可能Integer类型和String常量池也存在相似对问题
     * */

    private static Object lockObj = new Object();

    public TicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (quantity > 0) {
            synchronized (lock) {
                if (quantity > 0) {
                    System.out.println("通过" + getName() + "卖出了第" + quantity + "张票");
                    quantity--;
                } else {
                    System.out.println("票已经卖完");
                }
            }
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testJoin() throws Exception {
        synchronized (lockObj) {
            System.out.println("testJoin start");
            this.join(20000); //它会释放锁
            System.out.println("testJoin end");
        }
    }

    public void testSleep() throws Exception {
        synchronized (lockObj) {
            System.out.println("testSleep start");
            sleep(10000); // 它不会释放锁
            System.out.println("testSleep end");
        }
    }

    public static void main(String[] args) throws Exception {
        TicketThread ticketThread1 = new TicketThread("ticketThread1");
        TicketThread ticketThread2 = new TicketThread("ticketThread2");
        Thread thread = Thread.currentThread();
        ticketThread1.start();
        ticketThread2.start();
        ticketThread1.testJoin();
        ticketThread2.testSleep();
    }
}