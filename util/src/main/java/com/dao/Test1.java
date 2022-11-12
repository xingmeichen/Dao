package com.dao;

import java.util.Scanner;

/**
 * @project: JavaLearning
 * @description: 求一个数是是两个素数的乘积
 * @author: Mabel.Chen
 * @create: 2022-02-25 18:51
 **/
public class Test1 {

    /***
     *** 求一个数是否是素数
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (((num % 2) == 0) && 2 != num) {
            return false;
        } else if (((num % 3) == 0) && 3 != num) {
            return false;
        } else if (((num % 5) == 0) && 5 != num) {
            return false;
        } else if (((num % 7) == 0) && 7 != num) {
            return false;
        } else {
            return true;
        }
    }

    /***
     * 要计算一个数是哪两个素数的乘积，先确定从哪个数开始检索
     * 求得开始检索的数，那么终止检索的数也就相应地找到了，从而提高检索效率
     * */
    public static int searchStart(int input) {
        if (input % 2 == 0) {
            return 2;
        } else if (input % 3 == 0) {
            return 3;
        } else if (input % 5 == 0) {
            return 5;
        } else if (input % 7 == 0) {
            return 7;
        }
        return 11;
    }

    public static void doCalculate(int input) {
        if (input <= 3) {
            System.out.println("-1, -1");
        }
        int start = searchStart(input);
        int end = input / start + input % start;
        int a = start;
        boolean flag = false;
        while (a <= end) {
            if (isPrime(a)) {
                if (input % a == 0) {
                    int b = input / a;
                    if (isPrime(b)) {
                        System.out.println(a + ", " + b);
                        flag = true;
                        break;
                    }
                }
            }
            a++;
        }
        if (!flag) {
            System.out.println("-1, -1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            doCalculate(input);
        }
    }
    /***
     * 67 18 90 111 1882 638 190
     * -1, -1
     * -1, -1
     * -1, -1
     * 3, 37
     * -1, -1
     * 2, 941
     * -1, -1
     * 2, 319
     * -1, -1
     * -1, -1
     */
}