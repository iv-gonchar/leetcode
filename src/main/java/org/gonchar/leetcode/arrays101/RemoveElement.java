package org.gonchar.leetcode.arrays101;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
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
