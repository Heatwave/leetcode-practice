package com.heatwave.leetcode.contest.weekly._20230108_327;

public class _6283MaximumCountOfPositiveIntegerAndNegativeInteger {
    static class Solution {
        public int maximumCount(int[] nums) {
            int neg = 0;
            int pos = 0;
            for (int num : nums) {
                if (num < 0) {
                    neg += 1;
                } else if (num > 0) {
                    pos += 1;
                }
            }
            return Math.max(neg, pos);
        }
    }
}
