package org.gonchar.leetcode.tree;

import org.junit.jupiter.api.Test;

class TraverseTest {

    // B L P Q C E R O T S U
    @Test
    void preOrderTest() {
        Traverse preOrder = new PreOrderTraverse();
        BinaryTreeNode<Character> tree = new TreeFactory().generate();
        System.out.println();
        preOrder.traverse(tree);
    }

    // Q P C L R E B T O U S
    @Test
    void inOrderTest() {
        Traverse preOrder = new InOrderTraverse();
        BinaryTreeNode<Character> tree = new TreeFactory().generate();
        System.out.println();
        preOrder.traverse(tree);
    }

    // Q C P R E L T U S O B
    @Test
    void postOrderTest() {
        Traverse preOrder = new PostOrderTraverse();
        BinaryTreeNode<Character> tree = new TreeFactory().generate();
        System.out.println();
        preOrder.traverse(tree);
    }
}