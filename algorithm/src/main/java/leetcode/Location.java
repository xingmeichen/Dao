package leetcode;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-12-05 21:38
 **/
public class Location {

    public static class Node {
        private int x;
        private int y;
    }

    /**
     * 该算法题目成立，则nodes的size必须大于等于2
     * */
    public List<Node> calculateLocation(List<Node> nodes, int k) throws Exception {
        if (CollectionUtils.isEmpty(nodes) || nodes.size() == 1) {
            // 在这里抛出异常,这里最好用一个自定义异常，说明输入数据不合法
            throw new Exception();
        }
        List<Node> result = new ArrayList<>();
        result.add(nodes.get(0));
        int length = 0;
        for (int i = 1; i < nodes.size(); i++) {
            Node currentNode = nodes.get(i);
            Node theLastNode = nodes.get(i - 1);
            length += Math.abs((currentNode.x - theLastNode.x) + (currentNode.y - theLastNode.y));
            if (k <= length) {
                Node newNode = new Node();
                if (currentNode.x == theLastNode.x) {
                    newNode.x = currentNode.x;
                    newNode.y = Math.abs(currentNode.y - (length - k));
                } else if (currentNode.y == theLastNode.y) {
                    newNode.y = currentNode.y;
                    newNode.x = Math.abs(currentNode.x - (length - k));
                }
                result.add(newNode);
                // 重置length
                length = length - k;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        // TODO 测试方法是否正确
        Map<Location, String> map = new TreeMap<>();
    }
}