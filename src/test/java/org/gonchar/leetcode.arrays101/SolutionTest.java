package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void lengthOfLIS1() {
        assertEquals(4, solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    @Test
    void lengthOfLIS2() {
        assertEquals(4, solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    @Test
    void lengthOfLIS3() {
        assertEquals(1, solution.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

    @Test
    void lengthOfLIS4() {
        assertEquals(4, solution.lengthOfLIS(new int[]{40, 50, 45, 42, 7, 8, 9, 101}));
    }

    @Test
    void lengthOfLIS5() {
        assertEquals(8, solution.lengthOfLIS(new int[]{2, 5, 7, 45, 50, 55, 8, 10, 9, 12, 14, 10, 16}));
    }
}