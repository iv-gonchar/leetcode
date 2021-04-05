package org.gonchar.leetcode.arrays101;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        // corner case:
        // some negative candidate may not fit in 32 integer
        int maxProduct = Integer.MIN_VALUE;
        int l = 0;
        boolean zeroPresent = false;
        // if there are 0s, then split task
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroPresent = true;
                if (nums[l] != 0) {
                    int localMax = maxProductWithout0(nums, l, i);
                    maxProduct = localMax > maxProduct ? localMax : maxProduct;
                }
                l = i+1;
            }
        }
        int localMax = maxProductWithout0(nums, l, nums.length);
        maxProduct = localMax > maxProduct ? localMax : maxProduct;
        if (zeroPresent) {
            return maxProduct > 0 ? maxProduct : 0;
        } else {
            return maxProduct;
        }

    }

    public int maxProductWithout0(int[] nums, int l, int r) {
        if (l >= r) {
            return Integer.MIN_VALUE;
        }
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int wholeMax = Integer.MIN_VALUE;

        boolean firstNegMet = false;

        int negativesCount = 0;
        for(int i=l; i<r; i++) {
            int num = nums[i];
            if (firstNegMet) {
                rMax = rMax == Integer.MIN_VALUE ? num : rMax * num;
            }
            if (num < 0) {
                firstNegMet = true;
                negativesCount++;
                if (wholeMax > lMax) {
                    lMax = wholeMax;
                }
            }
            wholeMax = wholeMax == Integer.MIN_VALUE ? num : wholeMax * num;
        }
        if ((negativesCount & 1) == 0 || (r-l) == 1) {
            return wholeMax;
        } else {
            return lMax > rMax ? lMax : rMax;
        }
    }
}
