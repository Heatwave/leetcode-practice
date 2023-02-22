package com.heatwave.leetcode.problems;

public class _0122BestTimeToBuyAndSellStockii {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            int buy = -prices[0], sell = 0;

            for (int i = 1; i < n; i++) {
                buy = Math.max(buy, sell - prices[i]);
                sell = Math.max(sell, buy + prices[i]);
            }

            return sell;
        }
    }

    class SolutionDpOptimization {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            int buyYesterday = -prices[0], sellYesterday = 0;
            int buyToday = 0, sellToday = 0;

            for (int i = 1; i < n; i++) {
                buyToday = Math.max(buyYesterday, sellYesterday - prices[i]);
                sellToday = Math.max(sellYesterday, buyYesterday + prices[i]);
                buyYesterday = buyToday;
                sellYesterday = sellToday;
            }

            return sellToday;
        }
    }

    class SolutionDpExceedMemoryLimit {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 1][n + 1];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }

            return dp[n - 1][0];
        }
    }

    class SolutionGreedy {
        public int maxProfit(int[] prices) {
            int n = prices.length, ans = 0;
            for (int i = 1; i < n; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }

            return ans;
        }
    }
}
