package org.gonchar.leetcode.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode<V> {

    private V value;

    private BinaryTreeNode<V> left;

    private BinaryTreeNode<V> rigth;

    public BinaryTreeNode(V value) {
        this.value = value;
    }

    public BinaryTreeNode(V value, BinaryTreeNode<V> left, BinaryTreeNode<V> rigth) {
        this.value = value;
        this.left = left;
        this.rigth = rigth;
    }


}
