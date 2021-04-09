package com.mabel.calculation;

/**
 * @project: JavaLearning
 * @description: 移位运算
 * @author: Mabel.Chen
 * @create: 2021-03-27 11:08
 **/
public class Shifting {

    public static void main(String[] args) {
        System.out.println(3 << 4); // 二进制数 11 向左移4位 -> 11000 -> 48
        System.out.println(9 >> 2); // 二进制数 1000 向右移2位，-> 10 -> 2
    }
}