package com.mabel.bottom;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-12-19 11:47
 **/
public class GCDemo {

    private static final int oneMB = 1024 * 1024;

    /***
     * VM 参数 -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * 设置了 -XX:+PrintGCDetails 参数才会将GC日志打印出来
     * */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * oneMB];
        allocation2 = new byte[2 * oneMB];
        allocation3 = new byte[2 * oneMB];
        allocation4 = new byte[4 * oneMB]; // 出现一次Minor GC
    }

    public static void main(String[] args) {
        testAllocation();
    }
}