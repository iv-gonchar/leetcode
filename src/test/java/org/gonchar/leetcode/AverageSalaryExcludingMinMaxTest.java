package org.gonchar.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageSalaryExcludingMinMaxTest {

    private AverageSalaryExcludingMinMax solution = new AverageSalaryExcludingMinMax();

    @Test
    void average() {
        int[] input = {8000, 1000, 5000, 4000, 6000};
        assertEquals(5000.00, solution.average(input));
    }
}