package com.dao.tree.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @project: Dao
 * @description: 二叉树
 * @author: Mabel.Chen
 * @create: 2022-01-09 17:10
 **/
public class BinaryTree {

    private static BinaryTreeNode root;

    /***
     * 插入一个新的节点
     * @param node
     */
    public void insert(BinaryTreeNode node) {
        if (null == root) {
            root = node;
            root.setLeft(null);
            root.setRight(null);
            return;
        }
        BinaryTreeNode parent = root;
        BinaryTreeNode current = root;
        int dir = 0; // -1 表示左节点，1表示右节点, 0表示不做任何操作
        while (null != current) {
            if (current.compareTo(node) > 0) {
                // 要插入的节点小于等于当前节点
                parent = current;
                current = current.getLeft();
                dir = -1;
            } else if (current.compareTo(node) < 0) {
                // 要插入的节点大于当前节点
                parent = current;
                current = current.getRight();
                dir = 1;
            } else {
                // 要插入的节点等于当前节点
                if (null == current.getLeft()) {
                    // 当前节点的左节点为空，则将新的节点作为当前节点的左孩子
                    dir = 0;
                    current.setLeft(node);
                } else {
                    node.setLeft(current);
                    node.setRight(current.getRight());
                    current.setRight(null); // 这一步千万不能忘了。。。
                    if (current == root) {
                        root = node;
                    } else {
                        parent.setLeft(node);
                    }
                }
                break;
            }
        }
        if (dir == 0) {
            return;
        }
        switch (dir) {
            case -1 : parent.setLeft(node); break;
            case 1: parent.setRight(node); break;
            default: break;
        }
        // 如果代码执行了switch代码段，则说明新插入的节点没有子节点
        node.setLeft(null);
        node.setRight(null);
    }

    /***
     * 二叉树的层次遍历
     * 根入队列，根出队列，并且左右孩子如队列
     */
    public void layerOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new ConcurrentLinkedDeque();
        queue.add(root);
        while (0 < queue.size()) {
            BinaryTreeNode current = queue.remove();
            print(current.getData());
            if (null != current.getLeft()) {
                queue.add(current.getLeft());
            }
            if (null != current.getRight()) {
                queue.add(current.getRight());
            }
        }
    }

    /***
     * 先序遍历： 根左右
     * @param node
     */
    public void preorderTraversal(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        print(node.getData());
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
    }

    /***
     * 中序遍历： 左根右
     * @param node
     */
    public void inOrderTraversal(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        inOrderTraversal(node.getLeft());
        print(node.getData());
        inOrderTraversal(node.getRight());
    }

    /***
     * 后序遍历： 左右根
     * @param node
     */
    public void postOrderTraversal(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        print(node.getData());
    }



    public void print(Object o) {
        System.out.print(o + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        List<Integer> array = Arrays.asList(87, 88, 85, 83, 86, 87);
        array.forEach(item -> {
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
            node.setData(item);
            tree.insert(node);
        });
        System.out.print("层次遍历： ");
        tree.layerOrderTraversal(root);

        System.out.print("\n前序遍历： ");
        tree.preorderTraversal(root);

        System.out.print("\n中序遍历： ");
        tree.inOrderTraversal(root);

        System.out.print("\n后序遍历： ");
        tree.postOrderTraversal(root);

        System.out.println("\n");
    }
}