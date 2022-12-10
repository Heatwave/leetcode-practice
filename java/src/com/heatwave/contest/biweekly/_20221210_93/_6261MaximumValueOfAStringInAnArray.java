package com.heatwave.contest.biweekly._20221210_93;

public class _6261MaximumValueOfAStringInAnArray {
    static class Solution {
        public int maximumValue(String[] strs) {
            int max = 0;

            for (String str : strs) {
                boolean includeLetter = false;
                for (char c : str.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        includeLetter = true;
                        break;
                    }
                }
                int len = 0;
                if (includeLetter) {
                    len = str.length();
                } else {
                    len = Integer.parseInt(str);
                }
                max = Math.max(max, len);
            }

            return max;
        }
    }
}
