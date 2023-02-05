package com.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-12-20 22:17
 **/
public class Main {

    private int[] items;

    public Main(int capacity) {
        items = new int[capacity];
    }

    public static String test() {
        try {
            int i = 1 / 0;
            System.out.println("I am in the try block");
            return "try block";
        } catch (Exception exception) {
            System.out.println("I am in the catch block");
            return "return block";
        } finally {
            System.out.println("I am in the finally block");
            return "finally block";
        }
        // 下面这行代码编译不通过
        //return "out of try/catch/finally";
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(args.length);
        System.out.println(new Date());
        Date now = new Date();
        DateFormat format = new SimpleDateFormat();
        String formatedDate = format.format(now);
        System.out.println(formatedDate);
        String s = now.toString();
        System.out.println(s);
        String dateStr = "2021-07-05T10:07:45.000+0000";
        //输入的被转化的时间格式
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
        Date date1 = dff.parse(dateStr);
        System.out.println(date1);
    }
}