package com.dao.base.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @project: Dao
 * @description:
 * @see {@link LockSupport} 示例
 * @author: Mabel.Chen
 * @create: 2021-12-07 10:45
 **/
public class LockSupportDemo {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
            }
        });

        thread.start();
        Thread.sleep(15000);
        System.out.println("After 15 seconds");
        LockSupport.unpark(thread);
    }
}