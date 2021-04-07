package org.gonchar.leetcode.arrays101;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /*
     * Returns -1 if not balanced
     * For balanced tree returns its height
     */
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftH = height(root.left);
        if (leftH < 0) {
            return -1;
        }
        int rightH = height(root.right);
        if (rightH < 0 || Math.abs(leftH - rightH) > 1) {
            return -1;
        }
        return Math.max(leftH, rightH) + 1;

    }

    public static class TreeNode {
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
