package com.mabel;

import java.util.concurrent.CountDownLatch;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-09-11 11:38
 **/
public class CountDownLatchDemo extends Thread {

    private int num;
    public CountDownLatch latch;

    public CountDownLatchDemo(int num, CountDownLatch latch) {
        this.num = num;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("NO." + num + "线程执行");
        } catch (Exception e) {
            System.out.println("NO." + num + "线程出错");
        } finally {
            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 1; i <= 3; i++) {
            new CountDownLatchDemo(i, latch).start();
        }
        System.out.println("任务陆续开始执行");
        latch.await();
        System.out.println("所有任务已经执行完毕");
    }
}