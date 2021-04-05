package org.gonchar.leetcode.arrays101;

public class MaximumSubarrayStupid {

    public int solution(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int currentSum = 0;
            for (int j=i; j<nums.length; j++) {
                int num = nums[j];
                currentSum = currentSum + num;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}
