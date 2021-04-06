package org.gonchar.leetcode.tree;

import java.util.Stack;

public class PreOrderTraverse implements Traverse {

    @Override
    public void traverse(BinaryTreeNode<Character> root) {
        Stack<BinaryTreeNode<Character>> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            BinaryTreeNode<Character> current = stack.pop();
            System.out.print(current.getValue() + " ");
            if (current.getRigth() != null) {
                stack.push(current.getRigth());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }
}
