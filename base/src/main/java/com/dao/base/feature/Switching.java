package com.dao.base.feature;

import com.dao.base.common.User;

/**
 * @project: dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-07
 **/
public class Switching {

    // since 14 (Enhance switch block)
    public static void switching1(String input) {
        switch (input) {
            case "A" -> System.out.println("1");
            case "B" -> System.out.println("2");
            case "C" -> System.out.println("3");
            default -> System.out.println("");
        }
    }

    // since 17-Pattern matching for switch
    public static void switching1(Object obj) {
//        switch (obj) {
//            case null -> System.out.println("");
//            case Integer -> System.out.println("Integer");
//            case String -> System.out.println("String");
//            case User -> System.out.println("User");
//        }
    }

    public static void main(String[] args) {
        Object obj;
        Integer i;
        User user = new User();
    }
}