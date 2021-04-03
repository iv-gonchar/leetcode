package org.gonchar.leetcode.arrays101;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length-1;

        while (r-l > 0) {
            int med = l + (r - l) / 2;
            if (target < nums[med+1]) {
                r = med;
            } else {
                l = med+1;
            }
        }

        if (target <= nums[l]) {
            return l;
        } else {
            return l+1;
        }
    }
}
