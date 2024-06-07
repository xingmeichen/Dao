package com.dao.algorithm.base;

/**
 * @project: Dao
 * @description:
 * 数组变换
 * 给出一个长度为 n 的数组，和一个正整数 d。
 * 你每次可以选择其中任意一个元素 a[i] 将其变为 a[i] + d 或 a[i] - d，这算作一 次操作。
 * 你需要将所有的元素全部变成相等元素，如果有解，请输出最小操作次数，如果 无解请输出 -1。
 * 输入数字 n、数字 d，和一个长度为 n 的数组 a。1 <= n <= 100000，1 <= d <= 100, 1 <= a[i] <= 100000。
 * 输出一个数字，表示最小的操作次数，如果无解输出 -1。
 * 示例 1
 * 输入:
 * 5
 * 2 [3,5,7,1,9]
 * 输出:
 * 6
 * 注意
 * 最优解为全部变为 5，共 1 + 0 + 1 + 2 + 2 = 6 次。
 *
 * 解题思路：
 * 首先判断无解的情况，可以发现 a[i]，a[i]+d, a[i]-d 在 模 d 情况下的余数不会发生改变，
 * 因此如果原数组中的存在任意两个数字它们对 d 取余结果不同，那么此时无解。
 * 如果有解，开始求最小值，
 * 先将数组排序，取数组中间的数假设是a[middle]作为目标值（也就是最终数组的每一个数通过变换后都是这个数）
 * 求目标值的前middle项的和sumLeft，则前middle项变换需要的步数
 * leftSteps = (a[middle] * middle - sumLeft) / d
 * 求目标值的后k项的和sumRight, 则middle位置之后的所有项变换需要的步数
 * rightSteps = (sumRight - ((length - middle + 1)) / 2 * a[middle]) / d
 * 最终总的步数是 steps = leftSteps + rightSteps
 * @author: Mabel.Chen
 * @create: 2021-08-15 12:59
 **/
public class ArrayConvert {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static boolean isSolvable(int[] array, int d) {
        if (array.length <= 0) {
            return false;
        } else if (1 == array.length) {
            return true;
        }
        boolean solvable = true;
        int r = array[0] % d;
        for (int i = 1; i < array.length; i++) {
            if (r != array[i] % d) {
                solvable = false;
                break;
            }
        }
        return solvable;
    }

    public static int calculateStep(int[] array, int d) {
        if (!isSolvable(array, d)) {
            return -1;
        }
        array = sort(array);
        int mid = array[array.length / 2];
        int sumLeft = 0;
        int sumRight = 0;
        int length = array.length;
        for (int i = 0, j = length / 2 + 1; i < length / 2 || j < length; i++, j++) {
            if (i < length / 2) {
                sumLeft += array[i];
            }
            if (j < length) {
                sumRight += array[j];
            }
        }
        int leftStep = (mid * (length / 2) - sumLeft) / d;
        int rightStep = (sumRight - mid * ((length - (length / 2) + 1)) / 2) / d;
        return leftStep + rightStep;
    }

    public static void printArray(int[] array) {
        int i;
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[i]);
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,2,3,4,1,5,6,9,2};
        a1 = sort(a1);
        printArray(a1);
        int[] array = {3, 5, 1, 7, 9};
        int result = calculateStep(array, 2);
        System.out.println(result);

        int[] a2 = {3,5,5,7,9,15};
        result = calculateStep(a2, 2);
        System.out.println(result);
    }
}