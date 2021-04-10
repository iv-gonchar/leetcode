package org.gonchar.leetcode.arrays101;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array) {
        int index = 0;
        while (index < array.length - 1) {
            int nextMinPos = min(index, array);
            swap(index, nextMinPos, array);
            index++;
        }
    }

    /**
     * Returns min element position
     */
    private int min(int offset, int[] array) {
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i=offset; i<array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                pos = i;
            }
        }
        return pos;
    }

    private void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
