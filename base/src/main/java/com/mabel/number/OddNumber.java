package com.mabel.number;

/**
 * @project: JavaLearning
 * @description: 求一个数量是否为奇数的示例
 * @author: Mabel.Chen
 * @create: 2020-05-16 10:35
 **/
public class OddNumber {

    /**
     * 求i是否是奇数, 如果是奇数返回true, 否则返回false
     * 该方法咋看之下并没有什么问题，但是它真的是正确的吗？
     * 试着 将 i = -1, i = 0, i = 1 这三种用例都测试看看结果是什么
     * 结果你会发现，如果i是负数，那么该方法的返回值将永远是false
     * */
    public static boolean isOddV1(int i) {
        return i % 2 == 1;
    }

    /**
     * 求i是否是奇数, 如果是奇数返回true, 否则返回false
     * 该方法的结果是正确的，但是有没有一个更好的办法呢？请看 isOddV3(int i)
     * */
    public static boolean isOddV2(int i) {
        return i % 2 != 0;
    }

    /**
     * 求i是否是奇数, 如果是奇数返回true, 否则返回false
     * 如果是强调性能的环境中，那么用位操作符AND(&)替代取余操作符(%)会显得更好
     * */
    public static boolean isOddV3(int i) {
        return (i & 1) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isOddV1(-9));
    }
}