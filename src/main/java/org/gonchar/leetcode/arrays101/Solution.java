package org.gonchar.leetcode.arrays101;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        quickSort(pairs, 0, pairs.length - 1);
        int chain = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > prevEnd) {
                chain++;
                prevEnd = pairs[i][1];
            }
        }
        return chain;
    }

    private void quickSort(int[][] pairs, int s, int e) {
        if (s >= e) {
            return;
        }
        int pivot = partition(pairs, s, e);
        quickSort(pairs, s, pivot - 1);
        quickSort(pairs, pivot + 1, e);
    }

    private int partition(int[][] pairs, int s, int e) {
        int[] pivotVal = pairs[e];
        int lastSmallPos = s - 1;
        for (int i = s; i <= e; i++) {
            if (pairs[i][1] <= pivotVal[1]) {
                lastSmallPos++;
                swap(pairs, lastSmallPos, i);
            }
        }
        return lastSmallPos;
    }

    private void swap(int[][] pairs, int l, int r) {
        int[] temp = pairs[l];
        pairs[l] = pairs[r];
        pairs[r] = temp;
    }
}
