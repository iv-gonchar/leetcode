package org.gonchar.leetcode.arrays101;

import javax.swing.tree.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        int[] gain = robHouses(root);
        return Math.max(gain[0], gain[1]);
    }

    /*
        res[0] = gain if val of input node is not taken
        res[1] = gain if val of current is taken
     */
    public int[] robHouses(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = robHouses(node.left);
        int[] right = robHouses(node.right);
        int notTaken = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int taken = node.val + left[0] + right[0];
        return new int[]{notTaken, taken};
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
