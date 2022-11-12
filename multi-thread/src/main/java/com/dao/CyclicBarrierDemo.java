package com.dao;

import java.util.concurrent.CyclicBarrier;

/**
 * @project: JavaLearning
 * @description:
 * 用CyclicBarrier 模拟每三人一组乘车的场景
 * @author: Mabel.Chen
 * @create: 2021-09-11 12:01
 **/
public class CyclicBarrierDemo extends Thread {

    private int num;
    private CyclicBarrier barrier;

    public CyclicBarrierDemo(int num, CyclicBarrier barrier) {
        this.num = num;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("NO." + num + "已经开始步行出发");
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("NO." + num + "已经到达接驳站，开始等待其他人");
            barrier.await();
            System.out.println("NO." + num + "已经乘车");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        for (int i = 1; i <= 30; i++) {
            new CyclicBarrierDemo(i, barrier).start();
        }
    }
}