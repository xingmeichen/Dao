package com.dao.sort;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-07-14 12:45
 **/
public class PrintUtil {

    public static void printList(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("序列为空");
        }
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() -1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.println(list.get(i) + ".");
            }
        }
    }
}