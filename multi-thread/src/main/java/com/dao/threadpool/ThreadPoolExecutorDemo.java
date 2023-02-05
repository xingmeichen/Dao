package com.dao.threadpool;

import com.dao.ticket.TicketCallable;
import com.dao.ticket.TicketThread;

import java.util.concurrent.*;

/**
 * @project: Dao
 * @description: 线程池使用示例
 * @author: Mabel.Chen
 * @create: 2020-03-06 10:54
 **/
public class ThreadPoolExecutorDemo {

    public static void threadPoolDemo() {
        // Executors 工具类实际上还是通过 ThreadPoolExecutor 的构造方法去创建的线程池
        Executor executor = Executors.newCachedThreadPool();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        for (int i = 1; i <= 10; i++) {
            Thread thread = threadFactory.newThread(new TicketThread("Thread_" + i));
            executor.execute(thread);
        }
    }

    public static void executorServiceSubmitDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> a = executorService.submit(new TicketCallable("A"));
        try {
            Integer result = a.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        threadPoolDemo();
        executorServiceSubmitDemo();
    }
}
