package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayStupidTest {
    
    private MaximumSubarrayStupid problem = new MaximumSubarrayStupid();

    @Test
    void maxSubArray1() {
        assertEquals(6, problem.solution(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    void maxSubArray2() {
        assertEquals(1, problem.solution(new int[]{1}));
    }

    @Test
    void maxSubArray3() {
        assertEquals(23, problem.solution(new int[]{5,4,-1,7,8}));
    }

    @Test
    void maxSubArray4() {
        assertEquals(-3, problem.solution(new int[]{-4,-3,-8}));
    }

    @Test
    void maxSubArray5() {
        assertEquals(0, problem.solution(new int[]{-4,-3,0,-8}));
    }
}