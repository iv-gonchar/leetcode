package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarrayTest {

    private MaximumProductSubarray problem = new MaximumProductSubarray();

    @Test
    void maxProduct1() {
        assertEquals(6, problem.maxProduct(new int[]{2,3,-2,4}));
    }

    @Test
    void maxProduct2() {
        assertEquals(-2, problem.maxProduct(new int[]{-2}));
    }

    @Test
    void maxProduct3() {
        assertEquals(0, problem.maxProduct(new int[]{-2,0,-1}));
    }

    @Test
    void maxProduct4() {
        assertEquals(0, problem.maxProduct(new int[]{0}));
    }

    @Test
    void maxProduct5() {
        assertEquals(0, problem.maxProduct(new int[]{0,0,0,0}));
    }

    @Test
    void maxProduct6() {
        assertEquals(0, problem.maxProduct(new int[]{0,-2}));
    }

    @Test
    void maxProduct7() {
        assertEquals(2, problem.maxProduct(new int[]{-5,0,2}));
    }
}