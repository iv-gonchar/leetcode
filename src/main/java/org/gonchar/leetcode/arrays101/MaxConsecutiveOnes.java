package org.gonchar.leetcode.arrays101;

/*
    Problem:
    Given a binary array, find the maximum number of consecutive 1s in this array.
    Example 1:
    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        validateInput(nums);
        int maxSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
                currentSeries = 0;
            } else {
                currentSeries++;
            }
        }
        // when nums ends with ones series
        if (currentSeries > maxSeries) {
            maxSeries = currentSeries;
        }
        return maxSeries;
    }

    private void validateInput(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("Input should not be null");
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] != 1) {
                throw new IllegalArgumentException("Input should contain only 0 and 1");
            }
        }
    }
}
