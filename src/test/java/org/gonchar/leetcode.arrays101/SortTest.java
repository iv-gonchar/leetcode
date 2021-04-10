package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void selectionSortTest() {
        Sort sort = new SelectionSort();

        int[] array = factory.generate(100000, -50000, 100000);
        System.out.println("min=" + utils.min(array));
        System.out.println("max=" + utils.max(array));

        sort.sort(array);
        assertTrue(utils.isAsc(array));
    }

    @Test
    void bubbleSortTest() {
        Sort sort = new BubbleSort();

        int[] array = factory.generate(100000, -50000, 100000);
//        System.out.println(utils.toString(array));
        System.out.println("min=" + utils.min(array));
        System.out.println("max=" + utils.max(array));

        sort.sort(array);
//        System.out.println(utils.toString(array));
        assertTrue(utils.isAsc(array));
    }
}