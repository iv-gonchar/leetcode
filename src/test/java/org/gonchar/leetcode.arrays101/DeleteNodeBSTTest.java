package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeBSTTest {

    DeleteNodeBST solver = new DeleteNodeBST();

    @Test
    void deleteNode1() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n6 = new TreeNode(6, null, n7);
        TreeNode n5 = new TreeNode(5, n3, n6);

        solver.deleteNode(n5, 3);
        System.out.println(n5);
    }
}