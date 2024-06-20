package com.dao.base.feature;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class StreamDemo {

    public static void before() {
        Stream<String> strStream = Stream.of("a", "b", "c");
        List<String> list = strStream.collect(Collectors.toList());
        list.forEach(item -> System.out.print(item + ", "));
        System.out.println();
    }

    public static void afterUpgrade() {
        Stream<String> strStream = Stream.of("a", "b", "c");
        List<String> list = strStream.toList();
        list.forEach(item -> System.out.print(item + ", "));
        System.out.println();
    }

    public static void main(String[] args) {
        before();
        afterUpgrade();
    }
}