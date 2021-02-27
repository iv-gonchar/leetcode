package org.gonchar.leetcode.arrays101;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        // assume input array is not empty
        // corner cases: [9], [9,9], [9,9,9] etc - in such cases we need to increase array length
        boolean allNines = true;
        for (int i=0; i<digits.length; i++) {
            int digit = digits[i];
            if (digit != 9) {
                allNines = false;
                break;
            }
        }
        if (allNines) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }

        // in all other cases original array is enough
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }
}
