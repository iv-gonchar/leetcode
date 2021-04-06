package org.gonchar.leetcode.arrays101;

import java.util.Stack;

public class PathSumIterative {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int currentSum = targetSum;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        nodes.push(root);
        sums.push(targetSum);
        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            Integer sum = sums.pop();
            if (node.left == null && node.right == null) {
                if (node.val == sum) {
                    return true;
                }
                continue;
            } else {
                if (node.right != null) {
                    nodes.push(node.right);
                    sums.push(sum - node.val);
                }
                if (node.left != null) {
                    nodes.push(node.left);
                    sums.push(sum - node.val);
                }
            }
        }
        return false;
    }

    public class TreeNode {
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
