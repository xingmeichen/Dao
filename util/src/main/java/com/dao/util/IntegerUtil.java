package com.dao.util;

import java.util.Objects;

/**
 * @author Mabel
 */
public class IntegerUtil {

    public static boolean isNullZero(Integer param) {
        return null == param ? true : ((Objects.equals(0, param)) ? true : false);
    }

    public static void main(String[] args) {
        Integer param = null;
        System.out.println(isNullZero(param));
    }
}
