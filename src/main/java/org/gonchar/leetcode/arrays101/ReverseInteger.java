package org.gonchar.leetcode.arrays101;

public class ReverseInteger {

    public int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        int result = 0;
        while (x > 0) {
            if (result > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            result = 10 * result + x % 10;
            x = x / 10;
        }
        return positive ? result : -result;
    }
}
