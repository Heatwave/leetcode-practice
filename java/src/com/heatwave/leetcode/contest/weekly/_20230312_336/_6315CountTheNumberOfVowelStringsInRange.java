package com.heatwave.leetcode.contest.weekly._20230312_336;

import java.util.HashSet;
import java.util.Set;

public class _6315CountTheNumberOfVowelStringsInRange {
    class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            int ans = 0;
            for (int i = left; i <= right; i++) {
                String word = words[i];
                if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                    ans += 1;
                }
            }

            return ans;
        }
    }
}
