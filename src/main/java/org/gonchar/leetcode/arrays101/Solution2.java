package org.gonchar.leetcode.arrays101;

import java.util.Stack;

public class Solution2 {
    public int rob(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<int[]> left = new Stack<>();
        Stack<int[]> right = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisited = null;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode parent = stack.peek();
                if (parent.right != null && parent.right != lastVisited) {
                    node = parent.right;
                } else {
                    stack.pop();
                    // visit parent
                    int[] leftGain = parent.left == null ? new int[]{0, 0} : left.pop();
                    int[] rightGain = parent.right == null ? new int[]{0, 0} : right.pop();
                    int notTaken = Math.max(leftGain[0], leftGain[1])
                            + Math.max(rightGain[0], rightGain[1]);
                    int taken = parent.val + leftGain[0] + rightGain[0];
                    int[] currentGain = new int[]{notTaken, taken};
                    if (!stack.empty() && stack.peek().left == parent) {
                        // current is left child
                        left.push(currentGain);
                    } else {
                        // current is right child
                        right.push(currentGain);
                    }
                    lastVisited = parent;
                }
            }
        }
        int[] rootGain = right.pop();
        return Math.max(rootGain[0], rootGain[1]);
    }

    private static class TreeNode {
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
