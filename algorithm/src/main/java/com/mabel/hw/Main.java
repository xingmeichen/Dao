package com.mabel.hw;

import java.util.Scanner;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-01-12 15:37
 **/
public class Main {

    public static long doRepeatAdd(long num) {
        if (num < 10) {
            return num;
        }
        num = addAllNum(num);
        while (10 < num) {
            num = addAllNum(num);
        }
        return num;
    }

    public static long addAllNum(long num) {
        int result = 0;
        while (0 < num) {
            result += num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long in = scanner.nextLong();
            System.out.println("输入：" + in);
            System.out.println("输出：" + doRepeatAdd(in));
        }
    }
}