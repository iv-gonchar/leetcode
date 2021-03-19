package org.gonchar.leetcode.arrays101;

public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        // assume input argument is not null
        char[] chars = s.toCharArray();
        int index = 0;
        // 1. ignore leading whitespaces
        while (chars[index] == ' ') {
            index++;
        }
        // 2. determine sign
        boolean positive = true;
        if (chars[index] == '-') {
            positive = false;
        }
        // 3. ignore leading 0s
        while (chars[index] == '0') {
            index++;
        }
        // 4. convert to integer
        int result = 0;
        while (chars[index] >= '0' && chars[index] <= '9') {
            result = result * 10;
            int digit = chars[index++] - '0';
            if (positive) {
                result = result + digit;
            } else {
                result = result - digit;
            }
        }





        return result;
    }
}
