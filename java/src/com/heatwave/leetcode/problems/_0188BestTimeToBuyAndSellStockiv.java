package com.heatwave.leetcode.problems;

public class _0188BestTimeToBuyAndSellStockiv {
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            k = k * 2;
            int[][] dp = new int[n][k];

            for (int i = 0; i < k; i++) {
                dp[0][i] = i % 2 == 0 ? -prices[0] : 0;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    if (j == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                    } else if (j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                    }
                }
            }

            return dp[n - 1][k - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(2, new int[]{2, 4, 1});
    }
}
