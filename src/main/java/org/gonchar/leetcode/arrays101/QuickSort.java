package org.gonchar.leetcode.arrays101;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int s, int e) {
        if (s >= e) {
            return;
        }
        int pivot = partition(array, s, e);
        quickSort(array, s, pivot - 1);
        quickSort(array, pivot + 1, e);
    }

    private int partition(int[] array, int s, int e) {
        int pivotValue = array[e];
        int lastSmall = s - 1;
        for (int i=s; i<=e; i++) {
            if (array[i] < pivotValue) {
                lastSmall++;
                swap(array, lastSmall, i);
            }
        }
        lastSmall++;
        swap(array, lastSmall, e);
        return lastSmall;
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
