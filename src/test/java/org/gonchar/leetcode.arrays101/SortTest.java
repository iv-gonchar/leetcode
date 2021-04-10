package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortTest {

    private static final int SIZE = 100000;

    private static final int MIN = -50000;

    private static final int MAX = 100000;

    private final ArrayFactory factory = new ArrayFactory();

    private final SortTestUtils utils = new SortTestUtils();

    @Test
    @Disabled
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

        int[] array = factory.generate(SIZE, MIN, MAX);
        System.out.println("min=" + utils.min(array));
        System.out.println("max=" + utils.max(array));

        sort.sort(array);
        assertTrue(utils.isAsc(array));
    }

    @Test
    void bubbleSortTest() {
        Sort sort = new BubbleSort();

        int[] array = factory.generate(SIZE, MIN, MAX);
//        System.out.println(utils.toString(array));
        System.out.println("min=" + utils.min(array));
        System.out.println("max=" + utils.max(array));

        sort.sort(array);
//        System.out.println(utils.toString(array));
        assertTrue(utils.isAsc(array));
    }

    @Test
    void insertionSortTest() {
        Sort sort = new InsertionSort();

        int[] array = factory.generate(SIZE, MIN, MAX);
//        System.out.println(utils.toString(array));
        System.out.println("min=" + utils.min(array));
        System.out.println("max=" + utils.max(array));

        sort.sort(array);
//        System.out.println(utils.toString(array));
        assertTrue(utils.isAsc(array));
    }
}