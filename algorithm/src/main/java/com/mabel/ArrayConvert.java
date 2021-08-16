package com.mabel;

/**
 * @project: JavaLearning
 * @description:
 * 数组变换
 *
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