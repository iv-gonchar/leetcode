package org.gonchar.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashTableTest {

    @Test
    public void simpleTest() {
        MyHashTable<Integer, Integer> map = new MyHashTable<>();
        map.put(123, 573);
        assertEquals(573, map.get(123));
    }

    @Test
    public void collisionTest() {
        MyHashTable<Integer, Integer> map = new MyHashTable<>();
        map.put(123, 573);
        map.put(139, 845);
        assertEquals(845, map.get(139));
        assertEquals(573, map.get(123));
    }

    @Test
    public void resizeTest() {
        MyHashTable<Integer, Integer> map = new MyHashTable<>();
        for (int i = 124; i < 137; i++) {
            map.put(i, 1010);
        }
        assertEquals(13, map.size());
        assertEquals(32, map.capacity());
    }

    @Test
    public void resizeTest24() {
        MyHashTable<Integer, Integer> map = new MyHashTable<>();
        for (int i = 124; i < 149; i++) {
            map.put(i, 1010);
        }
        assertEquals(25, map.size());
        assertEquals(64, map.capacity());
    }

}