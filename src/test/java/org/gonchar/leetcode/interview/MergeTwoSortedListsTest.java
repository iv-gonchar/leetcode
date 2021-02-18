package org.gonchar.leetcode.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    private MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @Test
    void mergeTwoListsExample1() {
        ListNode l1 = ListNode.fromString("[1,2,4]");
        ListNode l2 = ListNode.fromString("[1,3,4]");
        ListNode output = ListNode.fromString("[1,1,2,3,4,4]");
        assertEquals(output, solution.mergeTwoLists(l1, l2));
    }

    @Test
    void mergeTwoListsExample2() {
        assertEquals(null, solution.mergeTwoLists(null, null));
    }

    @Test
    void mergeTwoListsExample3() {
        ListNode l1 = null;
        ListNode l2 = ListNode.fromString("[0]");
        ListNode output = ListNode.fromString("[0]");
        assertEquals(output, solution.mergeTwoLists(l1, l2));
    }

    @Test
    void mergeTwoListsMyTest() {
        ListNode l1 = ListNode.fromString("[-100,-100,-34,-21,4,92,100]");
        ListNode l2 = ListNode.fromString("[-100,-23,4,99]");
        ListNode output = ListNode.fromString("[-100,-100,-100,-34,-23,-21,4,4,92,99,100]");
        assertEquals(output, solution.mergeTwoLists(l1, l2));
    }
}