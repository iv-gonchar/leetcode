package org.gonchar.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode current = stack.peek();
            // in this case we should visit current node one more time
            if (current.left != null) {
                stack.add(current.left);
                // by doing it we mark, that left branch was already visited
                current.left = null;
            } else {
                output.add(current.val);
                // remove current, we won't return to it anymore
                stack.pop();
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
        }

        return output;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
