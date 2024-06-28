package com.dao.base.collection;

import java.util.List;
import java.util.Vector;

/**
 * @project: Dao
 * @description:
 * @see java.util.Vector
 * Vector VS ArrayList
 * 1. Vector 是线程安全的, 所以性能不及ArrayList
 * 2. 两者的容量（capacity）都是动态增长的，但是Vector每次增长为原来的两倍，而ArrayList只增长50%
 * @author: Mabel.Chen
 * @create: 2024-06-28
 **/
public class VectorDemo {

    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("C");
        vector.stream().forEach(System.out::println);
    }
}