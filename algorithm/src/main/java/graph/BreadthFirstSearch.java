package graph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-16 13:33
 **/
public class BreadthFirstSearch {

    /***
     * 用一个二维数组初始化一个图，两个节点之间可达用1表示，否则用0表示
     * */
    private int[][] map = {
            {0,0,1,1},
            {0,0,1,0},
            {1,1,0,0},
            {1,0,0,0}
    };

    public void print(int[][] map) {
        if (null == map || map.length <= 0) {
            return;
        }
        for (int i = 0; i < map.length; i++) {
            int[] array = map[i];
            for (int j = 0; j < array.length; j++) {
                if (0 < j) {
                    System.out.print(", ");
                }
                System.out.print(array[j]);
            }
            System.out.println("");
        }
    }

    public Queue breadthTravel(int[][] map, Queue<Integer> queue, int[] searchTag) {
        int index = - 1;
        if (0 < queue.size()) {
            index = queue.poll();
            System.out.println(index);
        } else {
            int i = 0;
            while (i < searchTag.length) {
                if (searchTag[i] == 0) {
                    index = i;
                    break;
                }
                i++;
            }
        }
        if (index == -1) {
            return queue;
        }
        searchTag[index] = 1;
        for (int i = 0; i < map[index].length; i++) {
            if (1 == map[index][i] && 0 == searchTag[i]) {
                queue.add(i);
                searchTag[i] = 1;
            }
        }
        breadthTravel(map, queue, searchTag);
        return queue;
    }

    public static void main(String[] args) {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Queue<Integer> queue = new LinkedBlockingQueue();
        queue.add(0);
        search.breadthTravel(search.map, queue, new int[search.map.length]);
    }
}