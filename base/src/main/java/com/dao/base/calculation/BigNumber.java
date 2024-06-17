package com.dao.base.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-17
 **/
public class BigNumber {

    public static void main(String[] args) {
        long a = 0l;
        long b = 9l;
//        long sum = Long.sum(a, b);
//        System.out.println(sum);
        int positive = 3;
//        System.out.println(BigDecimal.valueOf(positive).divide(BigDecimal.valueOf(7), 6, RoundingMode.HALF_UP));
        List<Long> list = new ArrayList<>(10);
        list.add(0l);
        Long aLong = list.set(0, 0l);
    }
}