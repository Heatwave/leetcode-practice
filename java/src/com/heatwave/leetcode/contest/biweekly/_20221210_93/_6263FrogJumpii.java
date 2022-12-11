package com.heatwave.leetcode.contest.biweekly._20221210_93;

public class _6263FrogJumpii {
    static class Solution {
        public int maxJump(int[] stones) {
            int n = stones.length;
            int max = 0;

            if (n == 2) {
                return stones[1];
            }

            for (int i = 0; i + 2 < n; i++) {
                int res = stones[i + 2] - stones[i];
                max = Math.max(max, res);
            }

            return max;
        }
    }
}
