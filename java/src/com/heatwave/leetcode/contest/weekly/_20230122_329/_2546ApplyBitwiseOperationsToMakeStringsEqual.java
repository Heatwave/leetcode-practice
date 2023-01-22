package com.heatwave.leetcode.contest.weekly._20230122_329;

public class _2546ApplyBitwiseOperationsToMakeStringsEqual {
    static class Solution {
        public boolean makeStringsEqual(String s, String target) {
            if (s.equals(target)) {
                return true;
            }
            int s0Count = 0, t0Count = 0;
            for (String str : s.split("")) {
                if (str.equals("0")) {
                    s0Count++;
                }
            }

            for (String str : target.split("")) {
                if (str.equals("0")) {
                    t0Count++;
                }
            }
            int n = s.length();
            if (t0Count == n) {
                return false;
            }
            if (s0Count == n) {
                return false;
            }
            return true;
        }
    }

    static class AnotherSolution {
        public boolean makeStringsEqual(String s, String target) {
            return s.contains("1") == target.contains("1");
        }
    }
}
