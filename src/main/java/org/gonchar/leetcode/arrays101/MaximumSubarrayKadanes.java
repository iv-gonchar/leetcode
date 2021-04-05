package org.gonchar.leetcode.arrays101;

public class MaximumSubarrayKadanes {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            currentSum = currentSum + num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
