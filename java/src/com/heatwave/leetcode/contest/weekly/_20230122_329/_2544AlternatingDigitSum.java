package com.heatwave.leetcode.contest.weekly._20230122_329;

public class _2544AlternatingDigitSum {
    static class Solution {
        public int alternateDigitSum(int n) {
            int ans = 0;
            String s = String.valueOf(n);
            int index = 0;
            for (String digit : s.split("")) {
                if (index++ % 2==0) {
                    ans += Integer.parseInt(digit);
                } else {
                    ans -= Integer.parseInt(digit);
                }
            }
            return ans;
        }
    }
}
