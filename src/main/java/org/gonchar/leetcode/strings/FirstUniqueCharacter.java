package org.gonchar.leetcode.strings;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        Map<Character, Integer> nonRepeating = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char charI = chars[i];
            if (nonRepeating.containsKey(charI)) {
                nonRepeating.put(charI, -1);
            } else {
                nonRepeating.put(charI, i);
            }
        }
        Iterator<Map.Entry<Character, Integer>> it = nonRepeating.entrySet().iterator();
        while (it.hasNext()) {
            int index = it.next().getValue().intValue();
            if (index != -1) {
                return index;
            }
        }
        return -1;
    }
}
