package com.dao.algorithm.sort;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Dao
 * @description: 选择排序的实现，选择排序是乱序排序
 * 选择排序就是从没有排序的元素中选择出最大或者最小的元素放到已经排序好的元素后面，
 * 以下方法排序中，有序序列由链表尾向链表头增长
 * @author: Mabel.Chen
 * @create: 2019-07-14 11:23
 **/
public class SelectSort {

    public List<Integer> sort(List<Integer> list, boolean reverse) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (reverse) {
                    // 降序序排序
                    if (list.get(index) < list.get(j)) {
                        index = j;
                    }
                } else {
                    // 升序排序
                    if (list.get(index) > list.get(j)) {
                        index = j;
                    }
                }
            }
            SwapUtil.swap(list, i, index);
        }
        return list;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,6,1,4,7,9,1);
        SelectSort selectSort = new SelectSort();
        System.out.print("befor sorting: ");
        PrintUtil.printList(list);
        selectSort.sort(list, false);
        System.out.print("after sorting: ");
        PrintUtil.printList(list);
    }
}