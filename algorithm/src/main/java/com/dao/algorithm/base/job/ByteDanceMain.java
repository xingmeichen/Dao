package com.dao.algorithm.base.job;

/**
 * @project: Dao
 * @description: （这是最粗暴的解法了，但是除了这个没有想到其他的了）
 * 题目是：
 * 字节跳动在北京有N个工区，形成一个环状，Bytebus是往返在各个工区的通勤车，
 * 按工区的顺序行驶，其中第 i 个工区有汽油 gas[i] 升。你有一辆油箱容量无限的的Bytebus，
 * 从第 i 个工区开往第 i+1 个工区需要消耗汽油 cost[i] 升。你从其中的一个工区出发，
 * 开始时油箱为空。如果你可以绕环路行驶一周，则返回出发时工区的编号，否则返回 -1。
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * @author: Mabel.Chen
 * @create: 2020-09-20 16:26
 **/
public class ByteDanceMain {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int target = findTarget(gas, cost);
        System.out.println(target);
    }

    public static int findTarget(int[] gas, int[] cost) {
        for (int index = 0; index < gas.length; index++) {
            int target = roundTrip(gas, cost, index);
            if (0 <= target) {
                return target;
            }
        }
        return -1;
    }

    public static int roundTrip(int[] gas, int[] cost, int start) {
        int size = gas.length;
        if (start < 0 || start > gas.length -1) {
            return -1;
        }
        int gasSum = gas[start];
        int costSum = 0;
        int target = start;
        for (int i = start; ; i++) {
            costSum += cost[start];
            if (gasSum < costSum){
                target = -1;
                break;
            }
            if (i == size - 1) {
                i = 0;
            }
            if (target == start) {
                break;
            }
            gasSum += gas[i];
        }
        return target;
    }
}