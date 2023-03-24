package com.heatwave.leetcode.contest.weekly._147;

public class _1137NthTribonacciNumber {
    class Solution {
        public int tribonacci(int n) {
            int[] dp = new int[Math.max(n + 1, 3)];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            if (n < 3) {
                return dp[n];
            }

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }

            return dp[n];
        }
    }
}
