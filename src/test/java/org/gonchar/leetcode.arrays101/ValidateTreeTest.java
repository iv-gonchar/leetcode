package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateTreeTest {

    private ValidateTree validator = new ValidateTree();

    @Test
    void isValidBST1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(2, n1, n3);

        assertTrue(validator.isValidBST(root));
    }

    @Test
    void isValidBST2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4, n3, n6);
        TreeNode root = new TreeNode(5, n1, n4);

        assertFalse(validator.isValidBST(root));
    }

    @Test
    void isValidBST3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n0 = new TreeNode(0, null, n1);

        assertTrue(validator.isValidBST(n0));
    }
}