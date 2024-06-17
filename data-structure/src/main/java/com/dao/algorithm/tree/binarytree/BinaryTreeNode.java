package com.dao.algorithm.tree.binarytree;

import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-01-09 17:11
 **/
@Data
public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public int compareTo(BinaryTreeNode node) {
        if (data instanceof Integer) {
            return ((Integer) data).compareTo((Integer) node.data);
        }
        //TODO
        return 0;
    }

}