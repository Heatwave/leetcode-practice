package com.heatwave.leetcode.contest.weekly._20230226_334;

import java.util.Arrays;

public class _6368FindTheDivisibilityArrayOfAString {
    static class Solution {
        public int[] divisibilityArray(String word, int m) {
            int n = word.length();
            int[] div = new int[n];

            long num = 0;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int c = charArray[i] - '0';
                num = ((num * 10) + c) % m;
                div[i] = num == 0 ? 1 : 0;
            }

            return div;
        }
    }

    public static void main(String[] args) {
        String s = "1010";
        Solution solution = new Solution();
        int[] ints = solution.divisibilityArray(s, 10);
        System.out.println(Arrays.toString(ints));
    }
}
