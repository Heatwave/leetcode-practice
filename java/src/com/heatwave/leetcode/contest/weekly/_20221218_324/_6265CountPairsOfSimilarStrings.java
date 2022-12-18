package com.heatwave.leetcode.contest.weekly._20221218_324;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _6265CountPairsOfSimilarStrings {
    static class Solution {
        public int similarPairs(String[] words) {
            List<Set<Character>> list = new ArrayList<>();
            for (String word : words) {
                Set<Character> set = new HashSet<>();
                for (char c : word.toCharArray()) {
                    set.add(c);
                }
                list.add(set);
            }

            int ans = 0;

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    Set<Character> seti = list.get(i);
                    Set<Character> setj = list.get(j);
                    if (seti.size() != setj.size()) {
                        continue;
                    }
                    boolean match = seti.stream().anyMatch(c -> !setj.contains(c));
                    if (match) {
                        continue;
                    }
                    ans += 1;
                }
            }

            return ans;
        }
    }
}
