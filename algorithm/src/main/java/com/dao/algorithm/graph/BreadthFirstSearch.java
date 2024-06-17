package com.dao.algorithm.graph;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-16 13:33
 **/
public class BreadthFirstSearch {

    /***
     * 用一个二维数组初始化一个图，两个节点之间可达用1表示，否则用0表示
     * 无向图的邻接矩阵有两个特点
     * （1）对角线（左上角至右下角）上的元素值全为0，表示每个点到它自身没有路径
     * （2）其他的元素关于对角线对称
     * */
    private int[][] graph = {
            {0,1,0,0,0,1,0,0,0},
            {1,0,1,0,0,0,1,0,1},
            {0,1,0,1,0,0,0,0,1},
            {0,0,1,0,1,0,1,1,1},
            {0,0,0,1,0,1,0,1,0},
            {1,0,0,0,1,0,1,0,0},
            {0,1,0,1,0,1,0,1,0},
            {0,0,0,1,1,0,1,0,1},
            {0,1,1,1,0,0,0,0,0}
    };

    private int[][] graph1 = {
            {0,1,1,0,0,0,0},
            {1,0,0,1,0,0,1},
            {1,0,0,0,0,1,1},
            {0,1,0,0,1,0,0},
            {0,0,0,1,0,1,1},
            {0,0,1,0,1,0,0},
            {0,1,1,0,1,0,0}
    };

    private int[][] graph2 = {
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

    public Queue breadthTravel(int[][] graph, Queue<Integer> queue, Set<Integer> set) {
        int index = - 1;
        if (0 < queue.size()) {
            index = queue.poll();
            System.out.println(index);
        } else {
            if (graph.length == set.size()) {
                // 说明了所有的节点都已经遍历到了，所以直接将队列中的元素打印出来
                while (0 < queue.size()) {
                    System.out.println(queue.poll());
                }
            }
        }
        if (index == -1) {
            return queue;
        }
        set.add(index);
        for (int i = 0; i < graph[index].length; i++) {
            if (1 == graph[index][i] && !set.contains(i)) {
                queue.add(i);
                set.add(i);
            }
        }
        breadthTravel(graph, queue, set);
        return queue;
    }

    public static void main(String[] args) {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Queue<Integer> queue = new LinkedBlockingQueue();
        queue.add(0);
        Set<Integer> set = new HashSet();
        search.breadthTravel(search.graph2, queue, set);
    }
}