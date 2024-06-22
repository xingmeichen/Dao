package com.dao.base.number;

import java.math.BigDecimal;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-21
 **/
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal ten = new BigDecimal(10);
        int precision = ten.precision();
        System.out.println("precision: " + precision);
    }
}