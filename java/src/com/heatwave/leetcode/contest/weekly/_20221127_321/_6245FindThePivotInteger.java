package com.heatwave.leetcode.contest.weekly._20221127_321;

public class _6245FindThePivotInteger {
    static class Solution {
        public int pivotInteger(int n) {
            if (n <= 1) {
                return n;
            }

            int mid = n - 1;
            while (mid >= n / 2) {
                int leftSum = 0, rightSum = 0;
                for (int i = 1; i <= mid; i++) {
                    leftSum += i;
                }
                for (int i = mid; i <= n; i++) {
                    rightSum += i;
                }
                if (leftSum != rightSum) {
                    mid--;
                } else {
                    return mid;
                }
            }

            return -1;
        }
    }
}
