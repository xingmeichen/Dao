package com.dao;

/**
 * @project: Dao
 * @description:
 * 用三个线程分别打印出A,B,C, 要求每个字母打印10次，且按ABC这样的顺序交替打印
 * @author: Mabel.Chen
 * @create: 2021-08-18 19:27
 **/
public class Printer extends Thread {

    private String name;
    private Object previous;
    private Object self;

    public Printer(String name, Object previous, Object self) {
        this.name = name;
        this.previous = previous;
        this.self = self;
    }

    @Override
    public void run()  {
        int count = 10;
        while (0 < count) {
            synchronized (previous) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    previous.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Printer pa = new Printer("A", c, a);
        Printer pb = new Printer("B", a, b);
        Printer pc = new Printer("C", b, c);

        pa.start();
        Thread.sleep(100); // sleep in order to print A first
        pb.start();
        Thread.sleep(100); // sleep in order to print B after printing A
        pc.start();
    }
}