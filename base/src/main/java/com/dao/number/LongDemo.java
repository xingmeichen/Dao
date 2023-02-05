package com.dao.number;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-05-16 11:04
 **/
public class LongDemo {

    /**
     * 这个函数的返回结果如我们所预想的一样是1000吗？
     * 执行这个函数我们会发现，其结果是5，而不是1000
     * 问题在于常数MICROS_PER_DAY的计算确实溢出了，虽然结算结果放入long中不会出现溢出，
     * 但是计算完全是以int运算来执行的，计算完之后才被提升为long,为什么计算是以int运算来执行呢？
     * 因为所有乘在一起的因子都是int数值，通过使用long常量来替代int常量作为每一个乘积的第一个因子，就能够改正这个程序，
     * 正确计算表达式请看longDivisionV2()
     *
     * 要点：当在操作很大的数字时，千万要提防溢出，它可是一个缄默杀手
     * */
    public static long longDivisionV1() {
        long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        long result = MICROS_PER_DAY / MILLIS_PER_DAY;
        return result;
    }

    /**
     *
     * */
    public static long longDivisionV2() {
        long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
        long result = MICROS_PER_DAY / MILLIS_PER_DAY;
        return result;
    }

    public static void main(String[] args) {
        long result = longDivisionV1();
        System.out.println(result);
        result = longDivisionV2();
        System.out.println(result);
    }
}