package com.mabel.graph;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-16 12:42
 **/
public class DeepFirstSearch {

    /***
     * 用一个二维数组初始化一个图，两个节点之间可达用1表示，否则用0表示
     * */
    private int[][] graph = {
            {0,0,1,1},
            {0,0,1,0},
            {1,1,0,0},
            {1,0,0,0}
    };

    public void print(int[][] graph) {
        if (null == graph || graph.length <= 0) {
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            int[] array = graph[i];
            for (int j = 0; j < array.length; j++) {
                if (0 < j) {
                    System.out.print(", ");
                }
                System.out.print(array[j]);
            }
            System.out.println("");
        }
    }

    /**
     * 递归实现深度优先搜索
     * */
    public void deepTravel(int[][] map, int[] road, int index) {
        road[index] = 1;
        System.out.println(index);
        for (int i = 0; i < map[index].length; i++) {
            if (map[index][i] == 1 && 0 == road[i]) {
                deepTravel(map, road, i);
            }
        }
    }

    public static void main(String[] args) {
        DeepFirstSearch dfs = new DeepFirstSearch();
        int[] road = new int[dfs.graph.length];
        dfs.deepTravel(dfs.graph, road, 0);
    }
}