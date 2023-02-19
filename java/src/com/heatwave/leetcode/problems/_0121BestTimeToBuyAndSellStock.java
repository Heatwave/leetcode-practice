package com.heatwave.leetcode.problems;

public class _0121BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int minPrice = prices[0];

            int max = 0;
            for (int i = 1; i < n; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                max = Math.max(max, prices[i] - minPrice);
            }

            return max;
        }
    }

    class SolutionDp {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 1) {
                return 0;
            }
            int minPrice = prices[0];

            int[] dp = new int[n + 1];
            dp[0] = 0;

            for (int i = 1; i < n; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            }

            return dp[n - 1];
        }
    }
}
