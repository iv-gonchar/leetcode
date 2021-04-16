package org.gonchar.leetcode.arrays101;

public class BestTimeToBuyStock {
    public int maxProfit(int[] prices) {
        // idea
        int currentMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < currentMin) {
                currentMin = prices[i];
                continue;
            }
            int profit = prices[i] - currentMin;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
