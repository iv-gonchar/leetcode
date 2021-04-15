package org.gonchar.leetcode.arrays101;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // [prev][curr]
        int[][] memo = new int[nums.length+1][nums.length];
        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return maxLISLength(-1, 0, nums, memo);
    }

    public int maxLISLength(int prev, int cur, int[] nums, int[][] memo) {
        if (cur == nums.length) {
            return 0;
        }
        if (memo[prev+1][cur] >= 0) {
            return memo[prev+1][cur];
        }
        int taken = 0;
        if (prev == -1 || nums[cur] > nums[prev]) {
            taken = 1 + maxLISLength(cur, cur + 1, nums, memo);
        }
        int notTaken = maxLISLength(prev, cur + 1, nums, memo);
        memo[prev+1][cur] = Math.max(taken, notTaken);
        return memo[prev+1][cur];
    }
}
