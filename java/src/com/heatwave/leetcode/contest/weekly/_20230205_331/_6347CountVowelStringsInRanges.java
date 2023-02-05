package com.heatwave.leetcode.contest.weekly._20230205_331;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _6347CountVowelStringsInRanges {
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            Set<Character> vowel = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());
            int[] prefixSum = new int[words.length];
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (vowel.contains(word.charAt(0)) && vowel.contains(word.charAt(word.length() - 1))) {
                    sum += 1;
                }
                prefixSum[i] = sum;
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                if (query[0] == 0) {
                    ans[i] = prefixSum[query[1]];
                } else {
                    ans[i] = prefixSum[query[1]] - prefixSum[query[0] - 1];
                }
            }
            return ans;
        }
    }
}
