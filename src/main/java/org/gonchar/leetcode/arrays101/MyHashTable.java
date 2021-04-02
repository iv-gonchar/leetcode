package org.gonchar.leetcode.arrays101;

/**
 * My attempt to implement simple HashTable.
 * Caution it wasn't well tested. There might be bugs
 *
 * @param <K>
 * @param <V>
 */
public class MyHashTable<K, V> {

    public static final int INITIAL_CAPACITY = 16;

    public static final int INITIAL_THRESHOLD = 12;

    private int capacity = INITIAL_CAPACITY;

    private int threshold = INITIAL_THRESHOLD;

    private int size = 0;

    @SuppressWarnings({"unchecked"})
    private Node<K, V>[] table = (Node<K, V>[]) new Node[capacity];

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int h = hash(key);
        int index = index(h);
        Node<K, V> bucket = table[index];
        while (bucket != null) {
            K currentKey = bucket.key;
            if (key.equals(currentKey)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            return null;
        }
        V prev = putVal(key, value);
        if (size > threshold) {
            resize();
        }
        return prev;
    }

    private void resize() {
        int oldCapacity = capacity;
        threshold = threshold << 1;
        capacity = capacity << 1;
        @SuppressWarnings({"unchecked"})
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[capacity];
        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> current = table[i];
            table[i] = null;
            if (current == null) {
                continue;
            }
            if (current.next == null) {
                int newIndex = index(current.hash);
                newTable[newIndex] = current;
            } else {
                Node<K, V> highHead = null, lowHead = null, highTail = null, lowTail = null;
                while (current != null) {
                    if ((current.hash & oldCapacity) != 0) {
                        // current goes to high
                        if (highHead == null) {
                            highHead = current;
                        } else {
                            highTail.next = current;
                        }
                        highTail = current;
                    } else {
                        // current goes to low
                        if (lowHead == null) {
                            lowHead = current;
                        } else {
                            lowTail.next = current;
                        }
                        lowTail = current;
                    }
                    current = current.next;
                }
                if (lowTail != null) {
                    lowTail.next = null;
                    newTable[i] = lowHead;
                }
                if (highTail != null) {
                    highTail.next = null;
                    newTable[i + oldCapacity] = highHead;
                }
            }
        }
        table = newTable;
    }

    private V putVal(K key, V value) {
        int h = hash(key);
        int index = index(h);
        Node<K, V> bucket = table[index];
        if (bucket == null) {
            bucket = new Node<>(key, value, h);
            table[index] = bucket;
            size++;
        } else {
            while (true) {
                K currentKey = bucket.key;
                if (key.equals(currentKey)) {
                    // replace
                    V prev = bucket.value;
                    bucket.value = value;
                    return prev;
                }
                if (bucket.next == null) {
                    bucket.next = new Node<>(key, value, h);
                    size++;
                    return null;
                }
                bucket = bucket.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private int index(int hash) {
        return hash & (capacity() - 1);
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }

    static class Node<K, V> {
        K key;
        V value;
        final int hash;
        Node<K, V> next;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
