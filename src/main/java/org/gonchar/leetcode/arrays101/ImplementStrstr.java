package org.gonchar.leetcode.arrays101;

public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            boolean found = true;
            for (int j=0, h=i; j<needle.length(); j++, h++) {
                if (haystack.charAt(h) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
