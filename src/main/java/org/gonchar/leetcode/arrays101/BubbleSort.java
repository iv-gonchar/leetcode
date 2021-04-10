package org.gonchar.leetcode.arrays101;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array) {
        boolean swapDone = true;
        int end = array.length - 1;
        while (swapDone) {
            swapDone = false;
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swapDone = true;
                    // swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            end--;
        }
    }
}
