package com.heatwave.leetcode.contest.biweekly._20221224_94;

public class _6273MaximumEnemyFortsThatCanBeCaptured {
    static class Solution {
        public int captureForts(int[] forts) {
            int ans = 0;
            int n = forts.length;

            boolean intoBreach = false;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (forts[i] == -1) {
                    intoBreach = false;
                    ans = Math.max(ans, count);
                    count = 0;
                    continue;
                }
                if (forts[i] == 1) {
                    intoBreach = true;
                    count = 0;
                    continue;
                }
                if (intoBreach) {
                    count++;
                }
            }

            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (forts[i] == -1) {
                    intoBreach = false;
                    ans = Math.max(ans, count);
                    count = 0;
                    continue;
                }
                if (forts[i] == 1) {
                    intoBreach = true;
                    count = 0;
                    continue;
                }
                if (intoBreach) {
                    count++;
                }
            }

            return ans;
        }
    }
}
