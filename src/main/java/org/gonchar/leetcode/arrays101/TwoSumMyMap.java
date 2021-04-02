package org.gonchar.leetcode.arrays101;

public class TwoSumMyMap {

    public int[] twoSum(int[] nums, int target) {
        MyMap map = new MyMap(nums.length);
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            Integer complementIndex = map.get(complement);
            if (complementIndex != null) {
                return new int[]{complementIndex, i};
            }
            map.put(num, i);
        }
        throw new RuntimeException("pair not found");
    }


    static class MyMap {

        private int capacity;

        private Node[] table;

        public MyMap(int maxElements) {
            capacity = computeCapacity(maxElements);
            table = new Node[capacity];
        }

        private int computeCapacity(int maxElements) {
            int capacity = 16;
            while (maxElements > capacity) {
                capacity = capacity << 1;
            }
            return capacity;
        }

        public Integer get(Integer key) {
            int index = index(key);
            Node bucket = table[index];
            while (bucket != null) {
                if (bucket.key.equals(key)) {
                    return bucket.value;
                }
                bucket = bucket.next;
            }
            return null;
        }

        public void put(Integer key, Integer value) {
            int index = index(key);
            Node bucket = table[index];
            if (bucket == null) {
                bucket = new Node(key, value);
                table[index] = bucket;
                return;
            }
            while (bucket != null) {
                if (bucket.key.equals(key)) {
                    bucket.value = value;
                    return;
                }
                if (bucket.next == null) {
                    Node newNode = new Node(key, value);
                    bucket.next = newNode;
                    return;
                }
                bucket = bucket.next;
            }
        }

        private int index(Integer key) {
            int h = key.hashCode();
            int hash = h ^ (h >>> 16);
            int index = hash & (capacity - 1);
            return index;
        }

        static class Node {
            Integer key;
            Integer value;
            Node next;

            Node(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

    }
}
