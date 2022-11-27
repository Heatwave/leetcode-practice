package com.heatwave.contest.weekly._20221127_321;

public class _6246AppendCharactersToStringToMakeSubsequence {
    static class Solution {
        public int appendCharacters(String s, String t) {
            if (s.contains(t)) {
                return 0;
            }

            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();

            int tIndex = 0;
            for (int i = 0; i < chars1.length && tIndex < chars2.length; i++) {
                if (chars1[i] == chars2[tIndex]) {
                    tIndex++;
                }
            }

            if (tIndex == chars2.length) {
                return 0;
            } else {
                return chars2.length - tIndex;
            }
        }
    }
}
