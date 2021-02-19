package org.gonchar.leetcode;

public class CheckArrayFormationThroughConcat {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        // assume pieces is m*n matrix
        int a = 0;  // index of number in arr
        int m = -1; // index of a piece in pieces matrix

        while (a < arr.length) {

            // find piece index
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i][0] == arr[a]) {
                    m = i;
                    break;
                }
            }
            // piece not found
            if (m == -1) {
                return false;
            }

            // piece found -> traverse it
            int n = 0;
            while (n < pieces[m].length) { // n always <= a
                if (pieces[m][n] != arr[a]) {
                    return false;
                }
                n++;
                a++;
            }
            m = -1;
        }
        return true;
    }
}
