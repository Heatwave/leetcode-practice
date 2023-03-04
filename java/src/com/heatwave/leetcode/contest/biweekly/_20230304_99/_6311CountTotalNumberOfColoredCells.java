package com.heatwave.leetcode.contest.biweekly._20230304_99;

public class _6311CountTotalNumberOfColoredCells {
    class Solution {
        public long coloredCells(int n) {
            return 2L * n * (n - 1) + 1;
        }
    }
}
