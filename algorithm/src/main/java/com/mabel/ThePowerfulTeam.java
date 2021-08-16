package com.mabel;

import java.util.Arrays;
import java.util.List;

/**
 * @project: JavaLearning
 * @description:
 * 求最强团队
 * 有一个阵营，里面有 n 个小队 (1<=n<=100)，每个小队都有他们的能力值 ai(0<=i
 * 现在有一个紧急情况，需要从这些小队中选出连续的几个小队，组成一个最强的团队。
 * 最强的团队的定义为这个团队的所有小队的平均能力值最高。如果有多个最强团队，则选包含小队最多的一个。
 * 现在请你写个程序，输出这个最强的团队包含的小队的个数。 输入小队的数量 n，和 n 个数，
 * 分别代表各小队的能力值 ai 输出一个数表示这个最强团队包含的小队的个数。
 * @author: Mabel.Chen
 * @create: 2021-08-16 21:00
 **/
public class ThePowerfulTeam {

    public static int calculate(List<Integer> list) {
        int result = 1, count = 1;
        int max = list.get(0);
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
                maxIndex = i;
                result = 1;
            } else if (max == list.get(i)) {
                if (maxIndex + 1 != i) {
                    count = 1;
                } else {
                    count++;
                    result = Math.max(result, count);
                }
                maxIndex = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1, 5, 5, 5, 4, 5, 5, 5, 5, 3);
        int calculate = calculate(list);
        System.out.println(calculate);
        List list2 = Arrays.asList(5, 6, 5, 6);
        calculate = calculate(list2);
        System.out.println(calculate);
    }
}