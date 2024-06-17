package com.dao.algorithm.dp;

/**
 * @project: Dao
 * @description:
 * 矩阵最小路径和
 * 给定一个矩阵，大小为 m，从左上角开始每次只能向右走或者向下走，最后达到 右下角的位置。
 * 路径中所有数字累加起来就是路径和，返回所有路径的最小路径和。
 * @author: Mabel.Chen
 * @create: 2021-08-25 19:17
 **/
public class TheShortestRoad {

//    public static int shortestRoad(int[][] array, int m) {
//        int sum = array[0][0];
//        for (int i = 0, j = 0; i < m - 1 || j < m - 1;) {
//            if (i == m - 1) {
//                j++;
//            } else if (j == m - 1) {
//                i++;
//            } else {
//                if (array[i][j+1] < array[i+1][j]) {
//                    j++;
//                } else {
//                    i++;
//                }
//            }
//            sum += array[i][j];
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        int[][] array = {{4,1,5,3},{3,2,7,7},{6,5,2,8},{8,9,4,5}};
//        int sum = shortestRoad(array, 4);
//        System.out.println(sum);
//        int[][] array2 = {{4,1,5,3},{3,2,4,1},{6,5,2,8},{8,9,4,5}};
//        sum = shortestRoad(array2, 4);
//        System.out.println(sum);
//    }
}