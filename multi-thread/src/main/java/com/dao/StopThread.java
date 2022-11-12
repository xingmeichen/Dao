package com.dao;

/**
 * @project: JavaLearning
 * @description: 该方法说明了即使是处于休眠状态的线程也能接收到interrupt（中断）信号，而不是等到休眠结束
 * @author: Mabel.Chen
 * @create: 2021-09-06 18:55
 **/
public class StopThread extends Thread {

    @Override
    public void run() {
        System.out.println("StopThread starts...");
        try {
            int count = 0;
            while (!Thread.currentThread().interrupted() && count++ < 1000) {
                System.out.println("Count " + count);
                Thread.sleep(300000);
            }
        } catch (InterruptedException e) {
            System.out.println("Current thread has been interrupted");
        }
        System.out.println("StopThread ends...");
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}