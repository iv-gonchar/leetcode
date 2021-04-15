package org.gonchar.leetcode.arrays101;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int size = 0;
        return findMax(0, sub, size, nums);
    }

    public int findMax(int curpos, int[] sub, int size, int[] nums) {
        if (curpos >= nums.length) {
            return size;
        }
        int current = nums[curpos];
        if (size == 0) {
            // include
            sub[size++] = current;
            int include = findMax(curpos + 1, sub, size, nums);
            // not include
            size--;
            int notInclude = findMax(curpos + 1, sub, size, nums);
            return Math.max(include, notInclude);
        } else if (sub[size-1] < current) {
            // include
            sub[size++] = current;
            int include = findMax(curpos + 1, sub, size, nums);
            // not include
            size--;
            int notInclude = findMax(curpos + 1, sub, size, nums);
            return Math.max(include, notInclude);
        } else {
            return findMax(curpos + 1, sub, size, nums);
        }
    }
}
