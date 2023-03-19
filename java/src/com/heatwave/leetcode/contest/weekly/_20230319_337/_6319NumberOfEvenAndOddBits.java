package com.heatwave.leetcode.contest.weekly._20230319_337;

public class _6319NumberOfEvenAndOddBits {
    class Solution {
        public int[] evenOddBit(int n) {
            int even = 0, odd = 0;
            String s = Integer.toBinaryString(n);
            StringBuilder sb = new StringBuilder(s);
            s = sb.reverse().toString();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (i % 2 == 0) {
                        even += 1;
                    } else {
                        odd += 1;
                    }
                }
            }

            return new int[]{even, odd};
        }
    }
}
