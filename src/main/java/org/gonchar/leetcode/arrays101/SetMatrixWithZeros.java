package org.gonchar.leetcode.arrays101;

public class SetMatrixWithZeros {

    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        // find all zeros
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }
        // fill requred rows with zeros
        for (int i=0; i<rows.length; i++) {
            if (rows[i]) {
                for (int j=0; j<matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // fill requred cols with zeros
        for (int j=0; j<cols.length; j++) {
            if (cols[j]) {
                for (int i=0; i<matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
