package com.dao.hw;

import java.util.Scanner;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-05-30 22:30
 **/
public class IntSequence {

    public static void calculateIntSequence(int sum, int size) {
        if (0 == size) {
            System.out.println(-1);
        }
        int first = (sum / size) - (size / 2);
        if ((first * size + (size - 1) * size / 2) != sum) {
            first++;
        }
        if (first <= 0) {
            System.out.println(-1);
            return;
        }
        int index = 0;
        if ((first * size + (size - 1) * size / 2) == sum) {
            while (index++ < size) {
                System.out.print(first++ + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int size = scanner.nextInt();
        calculateIntSequence(sum, size);
    }
}