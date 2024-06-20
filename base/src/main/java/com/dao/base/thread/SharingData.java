package com.dao.base.thread;

/**
 * @project: Dao
 * @description: 对共享数据的操作需要考虑到线程安全问题
 * @author: Mabel.Chen
 * @create: 2021-07-04 20:01
 **/
public class SharingData extends Thread {

    private int count = 0;
    private static int sharingCount = 0;

    @Override
    public void run() {
        while (count < 100) {
            System.out.println(Thread.currentThread().getName() + " is counting count=" + ++count);
        }
        while (sharingCount < 100) {
            System.out.println(Thread.currentThread().getName() + " is counting sharingCount=" + ++sharingCount);
        }
    }

    public static void main(String[] args) {
        SharingData t1 = new SharingData();
        SharingData t2 = new SharingData();
        SharingData t3 = new SharingData();
        SharingData t4 = new SharingData();
        SharingData t5 = new SharingData();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}