package com.dao;

/**
 * @project: Dao
 * @description:
 * join() 方法示例
 * 假设有两个线程，t1 和 t2, 在t1 中调用 t2.join()，
 * 表示在 t1 中运行到调用 t2.join()的地方之后开始调用t2 的run方法，
 * 直到 t2 运行完毕之后再继续运行 t1
 * @author: Mabel.Chen
 * @create: 2021-12-06 09:34
 **/
public class JoinDemo extends Thread {

    private String name;

    public JoinDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "正在运行");
    }

    public static void main(String[] args) throws Exception {
        JoinDemo ta = new JoinDemo("A");
        JoinDemo tb = new JoinDemo("B");
        ta.start();
        tb.start();
        ta.join(); // 让当前线程让出CPU，等待ta执行完毕后再运行自己的
        tb.join(); // 让当前线程让出CPU，等待tb执行完毕后再运行自己的
        /***
         * 因为是在当前线程 main 方法中调用了ta.join(), tb.join(),
         * 则以下这行语句一定是在最后执行
         */
        System.out.println("main方法运行结束");
    }
}