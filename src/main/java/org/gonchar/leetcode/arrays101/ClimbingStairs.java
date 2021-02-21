package org.gonchar.leetcode.arrays101;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // here n >=2
        int n_2 = 1; // n(m-2)
        int n_1 = 1; // n(m-1)
        int m = 0;   // n(m)
        // will be exec at least once
        for (int i = 2; i <= n; i++) {
            m = n_1 + n_2;
            n_2 = n_1;
            n_1 = m;
        }
        return m;
    }
}
