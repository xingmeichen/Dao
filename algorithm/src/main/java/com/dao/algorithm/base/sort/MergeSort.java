package com.dao.algorithm.base.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project: Dao
 * @description: 归并排序
 * @author: Mabel.Chen
 * @create: 2021-08-15 15:21
 **/
public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> list) {
        if (1 == list.size()) {
            return list;
        }
        int middle = list.size() / 2;
        List<Integer> leftList = list.subList(0, middle);
        List<Integer> rightList = list.subList(middle, list.size());
        return merge(mergeSort(leftList), mergeSort(rightList));
    }

    public static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> mergeList = new ArrayList<>();
        int i = 0, j = 0;
        int index = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) <= rightList.get(j)) {
                mergeList.add(index++, leftList.get(i));
                i++;
            } else {
                mergeList.add(index++, rightList.get(j));
                j++;
            }
        }
        while (i < leftList.size()) {
            mergeList.add(index++, leftList.get(i));
            i++;
        }
        while (j < rightList.size()) {
            mergeList.add(index++, rightList.get(j));
            j++;
        }
        return mergeList;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,6,1,4,7,9,1);
        System.out.print("before sorting: ");
        PrintUtil.printList(list);
        List list1 = mergeSort(list);
        System.out.print("after sorting: ");
        PrintUtil.printList(list1);
    }
}