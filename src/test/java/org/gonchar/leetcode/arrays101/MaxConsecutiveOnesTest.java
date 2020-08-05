package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    void wrongInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> solution.findMaxConsecutiveOnes(new int[]{0, 1, 2}));
        assertEquals("Input should contain only 0 and 1", exception.getMessage());
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

    @Test
    void bigArray() {
        int[] input = fromFile("arrayWith23Ones.txt");
        assertEquals(23, solution.findMaxConsecutiveOnes(input));
    }

    private int[] fromFile(String filename) {
        try {
            URL url = getClass().getResource(filename);
            System.out.println(url);
            Path path = Paths.get(url.toURI());
            Scanner scanner = new Scanner(path).useDelimiter("");
            List<Integer> sequence = new ArrayList<>();
            while (scanner.hasNext()) {
                sequence.add(scanner.nextInt());
            }
            return toArray(sequence);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int[] toArray(List<Integer> sequence) {
        int[] intArray = new int[sequence.size()];
        for (int i = 0; i < sequence.size(); i++) {
            intArray[i] = sequence.get(i);
        }
        return intArray;
    }
}