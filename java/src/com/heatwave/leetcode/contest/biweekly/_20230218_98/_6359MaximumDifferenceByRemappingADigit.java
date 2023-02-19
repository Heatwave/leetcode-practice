package com.heatwave.leetcode.contest.biweekly._20230218_98;

public class _6359MaximumDifferenceByRemappingADigit {
    class Solution {
        public int minMaxDifference(int num) {
            int max = 0, min = 0;
            String maxS = "9";
            String s = String.valueOf(num);
            String[] split = s.split("");
            for (String value : split) {
                if (!value.equals("9")) {
                    maxS = value;
                    break;
                }
            }
            max = Integer.parseInt(s.replaceAll(maxS, "9"));
            min = Integer.parseInt(s.replaceAll(split[0], "0"));
            return max - min;
        }
    }
}
