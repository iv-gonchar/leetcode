package org.gonchar.leetcode.tree;

import java.util.Stack;

public class InOrderTraverse implements Traverse {

    @Override
    public void traverse(BinaryTreeNode<Character> root) {
        Stack<BinaryTreeNode<Character>> stack = new Stack<>();
        BinaryTreeNode node = root;
        while(!stack.empty() || node != null) {
            // left or right
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                System.out.print(node.getValue() + " ");
                node = node.getRigth();
            }
        }
    }
}
