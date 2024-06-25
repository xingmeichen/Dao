package com.dao.base;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-01-04 13:09
 **/
public class TryCatchFinally {
    
    public static String test(int a, int b) {
        try {
            int i = a / b;
            System.out.println("I am in the try block");
            return "try block";
        } catch (Exception exception) {
            System.out.println("I am in the catch block");
            return "return block";
        } finally {
            System.out.println("I am in the finally block");
            System.out.println("------------------");
            return "finally block"; // 在finally块中return, 这个函数会永远返回 "finally block"
        }
        // 下面这行代码编译不通过
//        return "out of try/catch/finally";
    }

    public static int verifyReturn(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        } finally {
            return -2;
        }
    }

    public static void verifyFinally() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("In catch Exception");
            System.gc();
        } finally {
            System.out.println("In finally");
        }
    }

    public static void verifyFinally2() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("In catch Exception");
            System.exit(0);
        } finally {
            System.out.println("In finally");
        }
    }

    public static void main(String[] args) {
        System.out.println(test(1, 0));
        System.out.println("==================");
        System.out.println(test(1, 2));
        System.out.println("==================");
        int i = verifyReturn(0, 1);
        System.out.println(i);
        System.out.println("----------------");
        verifyFinally();
        System.out.println("-----------------");
        verifyFinally2();
    }
}