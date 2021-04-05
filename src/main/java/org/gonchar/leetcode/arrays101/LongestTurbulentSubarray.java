package org.gonchar.leetcode.arrays101;

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        int max = 0;
        int localMax = 0;

        for(int i=0; i<arr.length; i++) {
            if (localMax == 0
                    || (localMax == 1 && arr[i-1] != arr[i])
                    || isTurbulent(arr, i)) {
                localMax++;
            } else {
                if (localMax > max) {
                    max = localMax;
                }
                localMax = arr[i-1] == arr[i] ? 1 : 2;
            }
        }
        return max > localMax ? max : localMax;
    }

    public boolean isTurbulent(int[] arr, int i) {
        if (arr[i-1] == arr[i]) {
            return false;
        }
        return (arr[i-2] < arr[i-1] && arr[i-1] > arr[i])
                || (arr[i-2] > arr[i-1] && arr[i-1] < arr[i]);
    }
}
