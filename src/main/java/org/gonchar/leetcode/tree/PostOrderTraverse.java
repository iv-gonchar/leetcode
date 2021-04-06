package org.gonchar.leetcode.tree;

import java.util.Stack;

public class PostOrderTraverse implements Traverse {

    @Override
    public void traverse(BinaryTreeNode<Character> root) {
        Stack<BinaryTreeNode<Character>> stack = new Stack<>();
        BinaryTreeNode<Character> node = root; // next node to visit
        BinaryTreeNode<Character> lastVisited = null;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                // current element (node = null) is either left or right child
                // if it left, then left child was fully visited (it's value was visited)
                // when we visit value we store node to lastVisited
                BinaryTreeNode<Character> parent = stack.peek();
                if (parent.getRigth() != null && lastVisited != parent.getRigth()) {
                    node = parent.getRigth();
                } else {
                    // left and right - both visited
                    System.out.print(parent.getValue() + " ");
                    lastVisited = parent;
                    stack.pop();
                }
            }
        }
    }
}
