package com.mabel.sort;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @project: JavaLearning
 * @description: 冒泡排序，
 * 假设原无序序列长度是N, 总共需要遍历N-1次，遍历一次后无序序列长度减1，有序序列长度增1，每次遍历比较的次数是无序序列长度。
 * 以下方法排序中，有序序列由链表尾向链表头增长
 * @author: Mabel.Chen
 * @create: 2019-07-14 12:32
 **/
public class BubbleSort {

    public List<Integer> sort(List<Integer> list, boolean reverse) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        /** 外层循环表示需要遍历的次数，内层循环表示在尚未有序的序列中找到最大/最小值，
         * 每一次内层循环结束后，有序序列长度加1 */
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (reverse) {
                    // 降序排序
                    if (list.get(j) < list.get(j+1)) {
                        SwapUtil.swap(list, j, j+1);
                    }
                } else {
                    // 升序排序
                    if (list.get(j) > list.get(j+1)) {
                        SwapUtil.swap(list, j, j+1);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,6,1,4,7,9,1);
        BubbleSort bubbleSort = new BubbleSort();
        System.out.print("before sorting: ");
        PrintUtil.printList(list);
        bubbleSort.sort(list, false);
        System.out.print("after sorting: ");
        PrintUtil.printList(list);
    }
}