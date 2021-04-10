package org.gonchar.leetcode.arrays101;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(array, l, m);
        mergeSort(array, m + 1, r);
        merge(array, l, m, r);
    }

    private void merge(int[] array, int l, int m, int r) {
        int[] temp1 = new int[m - l + 1];
        for (int i = 0; i < temp1.length; i++) {
            temp1[i] = array[l+i];
        }
        int[] temp2 = new int[r - m];
        for (int i = 0; i < temp2.length; i++) {
            temp2[i] = array[m+1+i];
        }

        int t1 = 0;
        int t2 = 0;
        int arr = l;
        while (t1 < temp1.length && t2 < temp2.length) {
            if (temp1[t1] < temp2[t2]) {
                array[arr] = temp1[t1];
                t1++;
            } else {
                array[arr] = temp2[t2];
                t2++;
            }
            arr++;
        }
        while (t1 < temp1.length) {
            array[arr] = temp1[t1];
            t1++;
            arr++;
        }
        while (t2 < temp2.length) {
            array[arr] = temp2[t2];
            t2++;
            arr++;
        }
    }
}
