package org.gonchar.leetcode.arrays101;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int k =  Integer.MAX_VALUE;
        for(int n=0; n<nums.length; n++) {
            if (nums[n] > i) {
                if (nums[n] > j) {
                    return true;
                } else {
                    j = nums[n];
                }
            } else {
                i = nums[n];
            }
        }
        return false;
    }
}
