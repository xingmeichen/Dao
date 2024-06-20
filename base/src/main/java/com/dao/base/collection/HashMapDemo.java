package com.dao.base.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(1, 11);

        System.out.println(map.containsKey(1));
        System.out.println(map.get(1) == 11);
    }
}