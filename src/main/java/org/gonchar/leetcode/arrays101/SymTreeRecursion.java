package org.gonchar.leetcode.arrays101;

import javax.swing.tree.TreeNode;

public class SymTreeRecursion {
    public boolean isSymmetric(TreeNode root) {
        return areSymmetric(root.left, root.right);
    }

    public boolean areSymmetric(TreeNode left, TreeNode right) {
        // if both are null -> true
        if (left == null && right == null) {
            return true;
        }
        // if one is null, but another is not -> false
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // both children should be symmetric
        return areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
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
