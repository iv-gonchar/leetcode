package org.gonchar.leetcode.strings;

public class FirstUniqueCharacter2 {

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int[] letters = new int[26];
        // -1 means we didn't met this char before
        // -2 means not unique
        for (int i = 0; i < letters.length; i++) {
            letters[i] = -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char charI = chars[i];
            // convert char to int : char - 'a' will give 0 for 'a'
            int foundChar = charI - 'a';
            if (letters[foundChar] == -1) {
                letters[foundChar] = i;
            } else {
                letters[foundChar] = -2;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++) {
            int index = letters[i];
            if (index != -1 && index != -2 && index < result) {
                result = index;
            }
        }
        if (result != Integer.MAX_VALUE) {
            return result;
        } else {
            return -1;
        }
    }
}
