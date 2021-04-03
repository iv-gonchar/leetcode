package org.gonchar.leetcode.arrays101;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[] common = strs[0].toCharArray();
        int size = common.length;
        if (size == 0) {
            return "";
        }
        for(int i=1; i<strs.length; i++) {
            String current = strs[i];
            int newSize = 0;
            for(; newSize < size && newSize < current.length(); newSize++) {
                if (common[newSize] != current.charAt(newSize)) {
                    break;
                }
            }
            size = newSize;
            if (size == 0) {
                return "";
            }
        }
        return new String(common, 0, size);
    }
}
