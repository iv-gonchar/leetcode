package org.gonchar.leetcode.arrays101;

import java.util.Stack;

public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        int size = size(head);
        int[] answer = new int[size];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            while (!stack.empty()) {
                Pair pair = stack.peek();
                if (pair.val < head.val) {
                    stack.pop();
                    answer[pair.index] = head.val;
                } else {
                    break;
                }
            }
            stack.push(new Pair(i, head.val));
            head = head.next;
        }
        // for every remaining val in stack put 0 to answer
        while (!stack.empty()) {
            Pair pair = stack.pop();
            answer[pair.index] = 0;
        }
        return answer;
    }

    public int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public static class Pair {
        int index;
        int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
