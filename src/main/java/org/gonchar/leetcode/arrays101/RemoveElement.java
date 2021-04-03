package org.gonchar.leetcode.arrays101;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        // remove vals in the end
        for (;length > 0; length--) {
            if (nums[length-1] != val) {
                break;
            }
        }
        for (int i=0; i<length; i++) {
            if (nums[i] == val) {
                while (length > i) {
                    if (nums[--length] != val) {
                        nums[i] = nums[length];
                        break;
                    }
                }
            }
        }

        return length;
    }
}
