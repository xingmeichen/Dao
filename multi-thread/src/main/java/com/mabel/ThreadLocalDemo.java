package com.mabel;

import com.mabel.ticket.TicketThread;

/**
 * @project:
 * @description:
 * @author: Mabel.Chen
 * @create: 2020/4/10
 **/
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(555);
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
        TicketThread ticketThread1 = new TicketThread("ticketThread1");
        TicketThread ticketThread2 = new TicketThread("ticketThread2");
        //ticketThread1.start();
        //ticketThread2.start();
        while (0 < threadLocal.get()) {
            //System.out.println("当前数量" + threadLocal.get());
            threadLocal.set(threadLocal.get() - 1);

        }
    }
}
