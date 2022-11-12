package com.dao.job;

/**
 * @project:
 * @description: 任务调度框架 Quartz示例
 * @author: Mabel.Chen
 * @create: 2020/6/17
 **/
public class MabelJob {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public synchronized void testSyn() {
        System.out.println("Hello, I am [testSyn]");
    }

    public void testSyn(String name) {
        synchronized (this) {
            System.out.println("Hello, I am " + name);
        }
    }
}
