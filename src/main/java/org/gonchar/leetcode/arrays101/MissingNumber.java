package org.gonchar.leetcode.arrays101;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i=0; i<=n; i++) {
            result = result ^ i;
        }
        for (int i=0; i<nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
