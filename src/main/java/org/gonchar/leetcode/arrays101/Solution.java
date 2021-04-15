package org.gonchar.leetcode.arrays101;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int[] number = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            int curLengthMax = 0;
            int maxCount = 1;
            for (int j=0; j<=i-1; j++) {
                if (nums[i] > nums[j]) {
                    if (curLengthMax == length[j]) {
                        maxCount = maxCount + number[j];
                    } else if (curLengthMax < length[j]) {
                        curLengthMax = length[j];
                        maxCount = number[j];
                    }
                }
            }
            length[i] = curLengthMax + 1;
            number[i] = maxCount;
        }
        int maxLength = 0;
        int maxLengthCount = 0;
        for (int i=0; i<length.length; i++) {
            if (length[i] == maxLength) {
                maxLengthCount = maxLengthCount + number[i];
            } else if (length[i] > maxLength) {
                maxLength = length[i];
                maxLengthCount = number[i];
            }
        }

        return maxLengthCount;
    }
}
