package com.dao.algorithm.base.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Dao
 * @description: 遍历二叉树-->通过递归的方式
 * @author: Mabel.Chen
 * @create: 2020-09-14 22:29
 **/
public class TraversalBinaryTree {

    class TreeNode {
        private Integer value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() { }

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode initTreeNode() {
        TreeNode root = new TreeNode();
        root.value = 1;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    /**
     * 二叉树的前序遍历,顺序是：根左右
     * */
    public List<Integer> preOrderTraversal(TreeNode node, List<Integer> result) {
        if (null == node) {
            return result;
        }
        result.add(node.value);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
        return result;
    }

    /**
     * 二叉树的中序遍历，顺序是：左根右
     * */
    public List<Integer> inOrderTraversal(TreeNode node, List<Integer> result) {
        if (null == node) {
            return result;
        }
        inOrderTraversal(node.left, result);
        result.add(node.value);
        inOrderTraversal(node.right, result);
        return result;
    }

    /**
     * 二叉树的后序遍历，顺序是：左右根
     * */
    public List<Integer> postOrderTraversal(TreeNode node, List<Integer> result) {
        if (null == node) {
            return result;
        }
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.value);
        return result;
    }

    public List<Integer> traversal(TreeNode node, int order) {
        List<Integer> result = new ArrayList<>();
        if (1 == order) {
            preOrderTraversal(node, result);
        } else if (2 == order) {
            inOrderTraversal(node, result);
        } else if (3 == order) {
            postOrderTraversal(node, result);
        }
        return result;
    }

    public static void main(String[] args) {
        TraversalBinaryTree binaryTree = new TraversalBinaryTree();
        TreeNode treeNode = binaryTree.initTreeNode();
        List<Integer> result = binaryTree.traversal(treeNode, 1);
        System.out.println("前序列遍历--> " + result.toString());
        result = binaryTree.traversal(treeNode, 2);
        System.out.println("中序遍历--> " + result.toString());
        result = binaryTree.traversal(treeNode, 3);
        System.out.println("后序遍历--> " + result.toString());
    }
}