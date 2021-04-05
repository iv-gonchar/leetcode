package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestTurbulentSubarrayTest {

    private LongestTurbulentSubarray solution = new LongestTurbulentSubarray();

    @Test
    void maxTurbulenceSize1() {
        assertEquals(1, solution.maxTurbulenceSize(new int[] {9,9}));
    }

    @Test
    void maxTurbulenceSize2() {
        assertEquals(6, solution.maxTurbulenceSize(new int[] {1,2,1,2,1,2}));
    }

    @Test
    void maxTurbulenceSize3() {
        assertEquals(5, solution.maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}));
    }

    @Test
    void maxTurbulenceSize4() {
        assertEquals(2, solution.maxTurbulenceSize(new int[] {4,8,12,16}));
    }

    @Test
    void maxTurbulenceSize5() {
        assertEquals(1, solution.maxTurbulenceSize(new int[] {100}));
    }
}