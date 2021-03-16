package org.gonchar.leetcode.arrays101;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index2 = n - 1;
        int index1 = m - 1;
        int indexRes = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[indexRes] = nums1[index1];
                index1--;
            } else {
                nums1[indexRes] = nums2[index2];
                index2--;
            }
            indexRes--;
        }
        if (index2 == -1) {
            return;
        }
        if (index1 == -1) {
            // copy remaining nums from nums2
            // use Arrays.copy instead?
            for (; index2>=0; index2--) {
                nums1[indexRes] = nums2[index2];
                indexRes--;
            }
        }
    }
}
