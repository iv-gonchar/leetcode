package org.gonchar.leetcode.arrays101;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int leftmostGood = nums.length - 1;
        for (int i=nums.length - 2; i>=0; i--) {
            int jumpPower = nums[i];
            if (i + jumpPower >= leftmostGood) {
                leftmostGood = i;
            }
        }
        return leftmostGood == 0;
    }
}
