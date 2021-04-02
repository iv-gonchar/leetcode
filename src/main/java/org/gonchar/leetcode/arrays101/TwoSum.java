package org.gonchar.leetcode.arrays101;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // Put all numbers to indices map
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];

            // check there is second number in indices map
            int second = target - num;
            Integer secondNumIndex = indices.get(second);
            if (secondNumIndex != null) {
                result[0] = secondNumIndex;
                result[1] = i;
                return result;
            }

            // put current number in indices map
            indices.put(num, i);
        }
        
        return result;
    }
}
