package com.heatwave.leetcode.problems;

public class _0309BestTimeToBuyAndSellStockWithCoolDown {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 2) {
                return 0;
            }

            int[] buy = new int[n];
            int[] sell = new int[n];

            buy[0] = -prices[0];
            buy[1] = Math.max(-prices[0], -prices[1]);
            sell[0] = 0;
            sell[1] = Math.max(0, buy[0] + prices[1]);

            for (int i = 2; i < n; i++) {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            }

            return sell[n - 1];
        }
    }

    class SolutionMemoryOptimization {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 2) {
                return 0;
            }

            int buyYesterday = Math.max(-prices[0], -prices[1]);
            int buyToday;
            int sellTheDayBeforeYesterday = 0;
            int sellYesterday = Math.max(0, buyYesterday + prices[1]);
            int sellToday = 0;

            for (int i = 2; i < n; i++) {
                buyToday = Math.max(buyYesterday, sellTheDayBeforeYesterday - prices[i]);
                sellToday = Math.max(sellYesterday, buyYesterday + prices[i]);
                sellTheDayBeforeYesterday = sellYesterday;
                sellYesterday = sellToday;
                buyYesterday = buyToday;
            }

            return sellYesterday;
        }
    }
}
