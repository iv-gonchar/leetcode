package org.gonchar.leetcode.interview;

/*
    Problem:
    Merge two sorted linked lists and return it as a sorted list.
    The list should be made by splicing together the nodes of the first two lists.
    Example 1:
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {

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

        static ListNode fromString(String list) {
            if (list == null) {
                throw new IllegalArgumentException("Shouldn't be null");
            }
            if (list.length() < 2) {
                throw new IllegalArgumentException("list length should be at least 2 characters");
            }
            if (list.equals("[]")) {
                return null;
            }
            // check if list corresponds required pattern is omitted, but in production code it should be added

            // at this point we should have at least one element

            // remove all spaces if present
            String cleanedList = list.replaceAll("\\s+", "");
            // remove leading and trailing square brackets
            String elements = cleanedList.substring(1, cleanedList.length() - 2);
            String[] elementsArray = elements.split(",");

            int firstElement = Integer.valueOf(elementsArray[0]).intValue();
            ListNode head = new ListNode(firstElement);
            ListNode prev = head;
            for (int i = 1; i < elementsArray.length; i++) {
                int element = Integer.valueOf(elementsArray[i]).intValue();
                ListNode current = new ListNode(element);
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;
            }
            return head;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            ListNode current = this;
            while (true) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(",");
                    current = current.next;
                } else {
                    break;
                }
            }
            sb.append("]");
            return sb.toString();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (!other.getClass().equals(ListNode.class)) {
                return false;
            }
            ListNode otherList = (ListNode) other;
            ListNode currentThis = this;
            ListNode currentOther = otherList;
            while (currentThis != null || currentOther != null) {
                int thisCurrentElement = currentThis.val;
                int otherCurrentElement = otherList.val;
                if (thisCurrentElement != otherCurrentElement) {
                    return false;
                }
                currentThis = currentThis.next;
                currentOther = currentOther.next;
            }
            // check that both lists have same size
            if (currentThis != null || currentOther != null) {
                return false;
            }
            return true;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return new ListNode();
    }

}
