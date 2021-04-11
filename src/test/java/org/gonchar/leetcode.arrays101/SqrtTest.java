package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    private Sqrt sqrt = new Sqrt();

    @Test
    void mySqrt() {
        assertEquals(15, sqrt.mySqrt(234));
        assertEquals(32, sqrt.mySqrt(1056));
        assertEquals(351, sqrt.mySqrt(123456));
        assertEquals(31624, sqrt.mySqrt(1000123456));
    }
}