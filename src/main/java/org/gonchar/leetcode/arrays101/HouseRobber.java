package org.gonchar.leetcode.arrays101;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // at least 3 houses
        int[] dp = new int[nums.length];
        int dp_2 = nums[0];
        int dp_1 = Math.max(nums[0], nums[1]);
        int solution = 0;
        for (int i=2; i<nums.length; i++) {
            solution = Math.max(nums[i] + dp_2, dp_1);
            dp_2 = dp_1;
            dp_1 = solution;
        }
        return solution;
    }
}
