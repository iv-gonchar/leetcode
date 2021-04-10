package org.gonchar.leetcode.arrays101;

import java.util.Random;

public class ArrayFactory {

    private final Random rnd = new Random(System.currentTimeMillis());

    public int[] generate(int size, int min, int max) {
        int[] array = new int[size];
        int bound = max - min + 1;
        for (int i = 0; i < array.length; i++) {
            int next = min + rnd.nextInt(bound);
            array[i] = next;
        }
        return array;
    }
}
