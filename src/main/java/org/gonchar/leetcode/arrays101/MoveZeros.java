package org.gonchar.leetcode.arrays101;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        /*
            The idea:
            We traverse input array once.
            For each zero we increment int zeros variable
            For each non-zero element we need to move it left zeros times
            (the number of times which equals to zero elements met before this element)
        */


        int zeros = 0;
        // shift non-zeros elements
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeros++;
            } else {
                nums[i-zeros] = nums[i];
            }
        }
        // fill remaining part of array with 0
        for (int i=0; i<zeros; i++) {
            nums[nums.length-1-i] = 0;
        }
    }
}
