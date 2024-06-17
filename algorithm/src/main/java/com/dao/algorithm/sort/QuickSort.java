package com.dao.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Dao
 * @description: 快速排序
 * @author: Mabel.Chen
 * @create: 2021-08-15 14:09
 **/
public class QuickSort {

    public static List<Integer> quickSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(list, left, right);
            quickSort(list, left,partitionIndex - 1);
            quickSort(list,partitionIndex + 1, right);
        }
        return list;
    }

    /***
     * 该分区方法表示：
     * 取数组中的第left个数作为基准，用index表示基准数下标的下一个位置
     * 从left到right遍历数组，
     * 如果遇到比基准数的值小的数，则将其移动到基准数的下一个位置，也就是index的位置，比基准数小的序列长度加1，也就是index+1
     * */
    public static Integer partition(List<Integer> list, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (list.get(i) < list.get(pivot)) {
                if (i == index) {
                    // 如果 i 和 index刚好相等，则并不需要交换
                    index++;
                    continue;
                }
                SwapUtil.swap(list, i, index);
                index++;
            }
        }
        /** 把基准值放到求得的基准位置 */
        SwapUtil.swap(list, pivot, index - 1);
        return index - 1;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,6,1,4,7,9,1);
        System.out.print("before sorting: ");
        PrintUtil.printList(list);
        list = quickSort(list, 0, list.size() - 1);
        System.out.print("after sorting: ");
        PrintUtil.printList(list);
    }
}