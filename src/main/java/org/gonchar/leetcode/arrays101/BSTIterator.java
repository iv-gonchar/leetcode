package org.gonchar.leetcode.arrays101;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    TreeNode node;

    boolean nextComputed = false;

    TreeNode next;

    public BSTIterator(TreeNode root) {
        this.node = root;
    }

    public int next() {
        computeNext();
        if (next == null) {
            throw new RuntimeException("next is null");
        }
        int nextVal = next.val;
        nextComputed = false;
        next = null;
        return nextVal;
    }

    public boolean hasNext() {
        computeNext();
        return next != null;
    }

    /*
     * Moves pointer to the right if it wasn't done already
     */
    private void computeNext() {
        if (nextComputed) {
            return;
        }
        nextComputed = true;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                next = node;
                node = node.right;
                return;
            }
        }
        next = null;
    }

}
