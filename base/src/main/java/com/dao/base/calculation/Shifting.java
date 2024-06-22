package com.dao.base.calculation;

/**
 * @project: Dao
 * @description: 移位运算
 * @author: Mabel.Chen
 * @create: 2021-03-27 11:08
 **/
public class Shifting {

    public static void main(String[] args) {
        // 有符号左移
        System.out.println(3 << 4); // 二进制数 11 向左移4位 -> 11000 -> 48

        // 有符号右移
        System.out.println(9 >> 2); // 二进制数 1000 向右移2位，-> 10 -> 2

        // 无符号右移
        System.out.println(9 >>> 4); // 9向右移4位

        // Note: Java中没有无符号左移
    }
}