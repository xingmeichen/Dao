package com.mabel.number;

/**
 * @project: JavaLearning
 * @description: double类型可能出现的问题
 * @author: Mabel.Chen
 * @create: 2020-05-16 10:56
 **/
public class DoubleDemo {

    /**
     * 我们会发现输出结果会跟我们预想的不一样，
     * 因为并不是说有的消暑都可以用二进制浮点数精确表示，所以请注意：
     * 在需要精确答案的地方，要避免使用float和double,对于货币计算，要使用int, long或者BigDecimal
     * */
    public static void main(String[] args) {
        double result = 2.00 - 1.10;
        System.out.println(result);
    }
}