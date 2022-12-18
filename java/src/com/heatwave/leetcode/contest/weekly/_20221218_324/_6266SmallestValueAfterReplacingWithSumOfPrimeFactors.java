package com.heatwave.leetcode.contest.weekly._20221218_324;

public class _6266SmallestValueAfterReplacingWithSumOfPrimeFactors {
    static class Solution {
        public int smallestValue(int n) {
            int nxt = trans(n);
            while (nxt < n) {
                n = nxt;
                nxt = trans(n);
            }
            return n;
        }

        private int trans(int n) {
            int i = 2, sum = 0;
            while (i * i <= n) {
                if (n % i == 0) {
                    sum += i;
                    n /= i;
                } else {
                    i++;
                }
            }
            if (n != 1) {
                sum += n;
            }
            return sum;
        }
    }
}
