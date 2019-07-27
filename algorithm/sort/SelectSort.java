package algorithm.sort;

import algorithm.PrintUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @project: JavaLearning
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
            Integer a = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (reverse) {
                    // 降序序排序
                    if (a < list.get(j)) {
                        a = list.get(j);
                        list.set(j, list.get(i));
                        list.set(i, a);
                    }
                } else {
                    // 升序排序
                    if (a > list.get(j)) {
                        a = list.get(j);
                        list.set(j, list.get(i));
                        list.set(i, a);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,6,1,4,7,9,1);
        SelectSort selectSort = new SelectSort();
        System.out.print("befor sorting: ");
        PrintUtil.printList(list);
        selectSort.sort(list, true);
        System.out.print("after sorting: ");
        PrintUtil.printList(list);
    }
}