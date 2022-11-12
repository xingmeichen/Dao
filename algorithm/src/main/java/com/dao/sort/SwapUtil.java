package com.dao.sort;

import java.util.List;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-08-16 19:18
 **/
public class SwapUtil {

    public static void swap(List<Integer> list, int m, int n) {
        int size = list.size();
        if (m < 0 || (size-1) < m || n < 0 || (size - 1) < n) {
            throw new RuntimeException("Illegal index of List!");
        }
        int temp = list.get(m);
        list.set(m, list.get(n));
        list.set(n, temp);
    }
}