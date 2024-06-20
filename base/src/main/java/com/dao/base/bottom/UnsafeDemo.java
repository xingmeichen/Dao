package com.dao.base.bottom;

import sun.misc.Unsafe;

/**
 * @project: Dao
 * @description:
 * Unsafe 类的一些用途
 * 手动管理内存
 * 原子操作
 * 绕过Java语言层面的安全检查
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class UnsafeDemo {

    private final static Unsafe unsafe = Unsafe.getUnsafe();

    public static void main(String[] args) {
        int i = unsafe.addressSize();
        System.out.println(i);
    }
}