package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {

    @Test
    public void test1() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15, n9, n20);
        TreeNode n7 = new TreeNode(7, n3, n15);

        BSTIterator it = new BSTIterator(n7);
        System.out.println(it.next());    // return 3
        System.out.println(it.next());    // return 7
        System.out.println(it.hasNext()); // return True
        System.out.println(it.next());    // return 9
        System.out.println(it.hasNext()); // return True
        System.out.println(it.next());    // return 15
        System.out.println(it.hasNext()); // return True
        System.out.println(it.next());    // return 20
        System.out.println(it.hasNext()); // return False
    }

}