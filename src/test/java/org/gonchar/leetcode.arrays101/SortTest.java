package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SortTest {

    private final ArrayFactory factory = new ArrayFactory();

    private final SortTestUtils utils = new SortTestUtils();

    @Test
    void factoryAndUtilsDemo() {
        int[] array = factory.generate(50, -50, 100);
        System.out.println(utils.toString(array));
        System.out.println("min=" + utils.min(array));
        System.out.println("max=" + utils.max(array));
        assertFalse(utils.isAsc(array));
        assertFalse(utils.isDesc(array));
    }
}