package org.gonchar.leetcode.arrays101;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int maxLength = 0;
        for(int i=0; i<nums.length; i++) {
            int max = 0;
            for(int j=0; j<=i-1; j++) {
                if (nums[i]>nums[j] && max<dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }
}
