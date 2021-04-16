package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodSolutionTest {

    GoodSolution solution = new GoodSolution();

    @Test
    void findNumberOfLIS1() {
        assertEquals(2, solution.findNumberOfLIS(new int[]{1,3,5,4,7}));
    }

    @Test
    void findNumberOfLIS2() {
        assertEquals(2, solution.findNumberOfLIS(new int[]{2,5,7,45,50,55,8,10,9,12,14,10,16}));
    }
}