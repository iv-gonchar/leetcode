package org.gonchar.leetcode.arrays101;

public class Sqrt {
    public int mySqrt(int x) {
        // we should find number s, for which s*s <= x, but (s+1)*(s+1) > x
        // binary search?
        // lets imagine that we have an array with numbers [0, ... x] and we should find element which satisfies above condition
        int l = 0;
        int r = x;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long square = m*m;
            long nextSquare = (m+1)*(m+1);
            if (square <= x && nextSquare > x) {
                return (int) m;
            } else if(square > x) {
                r = (int)m - 1;
            } else {
                l = (int)m + 1;
            }
        }
        return r;
    }
}
