package org.gonchar.leetcode.arrays101;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfNumArray {
    static class NumOccurrence {
        int freq;
        int firstPos;
        int lastPos;

        public NumOccurrence(int firstPos) {
            this.firstPos = firstPos;
            this.lastPos = firstPos;
            this.freq = 1;
        }
    }

    public int findShortestSubArray(int[] nums) {
        // 1. compute degree
        int degree = 0;
        Map<Integer, NumOccurrence> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            NumOccurrence occurs = map.get(nums[i]);
            if (occurs == null) {
                occurs = new NumOccurrence(i);
                map.put(nums[i], occurs);
            } else {
                occurs.freq++;
                occurs.lastPos = i;
            }
            if (occurs.freq > degree) {
                degree = occurs.freq;
            }
        }
        // time: O(N)
        // memory: O(N)

        // 2. find min sub-array with minimum length
        int minLength = nums.length;
        for (Map.Entry<Integer, NumOccurrence> entry : map.entrySet()) {
            NumOccurrence occurs = entry.getValue();
            if (occurs.freq == degree) {
                int length = occurs.lastPos - occurs.firstPos + 1;
                if (length < minLength) {
                    minLength = length;
                }
            }
        }
        // time: O(N) + O(N) = O(N)
        // space: O(1)
        return minLength;
    }
    // final
    // time: O(N)
    // memory: O(N)
}
