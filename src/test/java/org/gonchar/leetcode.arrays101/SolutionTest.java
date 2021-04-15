package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void findLongestChain() {
        int[][] pairs = new int[][]{
                {3,4},
                {2,3},
                {1,2}
        };
        assertEquals(2, solution.findLongestChain(pairs));
    }
}