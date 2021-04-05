package org.gonchar.leetcode.arrays101;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int i = 0; // index
        int maxSum = 0; // stores prev max sum
        int candidateSum = 0;  // candidate max sum
        int maxNegative = -100001;
        boolean prevPos = false;

        while (i<nums.length) {
            int num = nums[i];

            // positive area ---------
            if (num > 0) {
                candidateSum = candidateSum + num;
                prevPos = true;

            // negative area --------
            } else {
                if (num > maxNegative) {
                    maxNegative = num;
                }
                if (candidateSum == 0) {
                    i++;
                    continue;
                }


                if (prevPos) {
                    if (candidateSum >= maxSum) {
                        maxSum = candidateSum;
                    }
                }
                candidateSum = candidateSum + num;
                if (candidateSum < 0) {
                    candidateSum = 0; // ignore prev positive area, it is isolated on right side
                }
                prevPos = false;
            }
            i++;
        }
        if (maxSum <= 0 && candidateSum <= 0) {
            return maxNegative;
        }

        // compute result
        return maxSum > candidateSum ? maxSum : candidateSum;
    }

}
