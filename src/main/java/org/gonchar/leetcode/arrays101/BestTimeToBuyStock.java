package org.gonchar.leetcode.arrays101;

public class BestTimeToBuyStock {

    /*
        This solution is not effective enough
     */
    public int maxProfit(int[] prices) {
        int[] firstIndex = new int[10001];
        int[] lastIndex = new int[10001];
        int min = 10001;
        int max = 0;

        for (int i = 0; i <= 10000; i++) {
            firstIndex[i] = -1;
            lastIndex[i] = -1;
        }

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price > max) {
                max = price;
            }
            if (price < min) {
                min = price;
            }
            if (firstIndex[price] == -1) {
                firstIndex[price] = i;
            }
            lastIndex[price] = i;
        }

        int maxProfit = max - min;
        for (int profit = maxProfit; profit >= 0; profit--) {
            for (int i = min; i+profit <= max; i++) {
                if (firstIndex[i] != -1 && firstIndex[i] < lastIndex[i + profit]) {
                    return profit;
                }
            }
        }
        return 0;
    }
}
