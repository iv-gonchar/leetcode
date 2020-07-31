package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxConsecutiveOnesTest {

    private MaxConsecutiveOnes solution = new MaxConsecutiveOnes();

    @Test
    void nullInput() {
        Exception exception = assertThrows(NullPointerException.class, () -> solution.findMaxConsecutiveOnes(null));
        assertEquals("Input should not be null", exception.getMessage());
    }

    @Test
    void emptyArrayInput() {
        assertEquals(0, solution.findMaxConsecutiveOnes(new int[]{}));
    }

    @Test
    void noOnesInInput() {
        assertEquals(0, solution.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0}));
    }

    @Test
    void onesInTheBeginning() {
        assertEquals(3, solution.findMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 0, 0, 0}));
    }

    @Test
    void onesInTheMiddle() {
        assertEquals(2, solution.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 1, 1, 0, 0}));
    }

    @Test
    void onesInTheEnd() {
        assertEquals(4, solution.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1}));
    }

    @Test
    void severalSeries() {
        assertEquals(5, solution.findMaxConsecutiveOnes(
                new int[]{0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0}));
    }
}