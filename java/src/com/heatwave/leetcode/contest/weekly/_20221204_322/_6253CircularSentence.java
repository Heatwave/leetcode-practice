package com.heatwave.leetcode.contest.weekly._20221204_322;

import java.util.Arrays;

public class _6253CircularSentence {
    static class Solution {
        public boolean isCircularSentence(String sentence) {
            String[] s = sentence.split(" ");
            String first = s[0], last = s[s.length - 1];
            if (first.charAt(0) != last.charAt(last.length() - 1)) {
                return false;
            }
            if (s.length > 1) {
                int firstIndex = 0, secondIndex = 1;
                while (secondIndex < s.length) {
                    first = s[firstIndex];
                    last = s[secondIndex];
                    if (first.charAt(first.length() - 1) != last.charAt(0)) {
                        return false;
                    }
                    firstIndex++;
                    secondIndex++;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(Arrays.toString(s.split(" ")));
    }
}
