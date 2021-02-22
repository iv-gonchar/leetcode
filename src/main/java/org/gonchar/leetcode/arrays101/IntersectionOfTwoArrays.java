package org.gonchar.leetcode.arrays101;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        // assume we need to find all numbers present in both arrays regardless their order
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i=0; i<nums1.length; i++) {
            int num = nums1[i];
            Integer quantity = map1.get(num);
            if (quantity == null) {
                map1.put(num, 1);
            } else {
                map1.put(num, quantity + 1);
            }
        }

        for (int i=0; i<nums2.length; i++) {
            int num = nums2[i];
            Integer quantity = map2.get(num);
            if (quantity == null) {
                map2.put(num, 1);
            } else {
                map2.put(num, quantity + 1);
            }
        }

        Set<Integer> keys = map1.size() < map2.size() ? map1.keySet() : map2.keySet();

        for (Integer key : keys) {
            Integer quantity1 = map1.get(key);
            Integer quantity2 = map2.get(key);
            if (quantity1 != null && quantity2 != null) {
                int times = quantity1 < quantity2 ? quantity1 : quantity2;
                for (int i = 0; i < times; i++) {
                    resultList.add(key);
                }
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
