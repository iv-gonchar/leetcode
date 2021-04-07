package org.gonchar.leetcode.arrays101;

public class ValidateTreeCorrect {
    public boolean isValidBST(TreeNode root) {
        return isValidBSSubtree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSSubtree(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSSubtree(root.left, min, root.val) && isValidBSSubtree(root.right, root.val, max);
    }
}
