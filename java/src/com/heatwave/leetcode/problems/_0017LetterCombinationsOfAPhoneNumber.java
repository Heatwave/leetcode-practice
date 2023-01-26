package com.heatwave.leetcode.problems;

import java.util.*;

public class _0017LetterCombinationsOfAPhoneNumber {
    static class Solution {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<Character, List<String>> map = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return ans;
            }

            map.put('2', Arrays.asList("a", "b", "c"));
            map.put('3', Arrays.asList("d", "e", "f"));
            map.put('4', Arrays.asList("g", "h", "i"));
            map.put('5', Arrays.asList("j", "k", "l"));
            map.put('6', Arrays.asList("m", "n", "o"));
            map.put('7', Arrays.asList("p", "q", "r", "s"));
            map.put('8', Arrays.asList("t", "u", "v"));
            map.put('9', Arrays.asList("w", "x", "y", "z"));

            backtracking(digits, 0);
            return ans;
        }

        private void backtracking(String digits, int index) {
            if (sb.length() == digits.length()) {
                ans.add(sb.toString());
                return;
            }

            List<String> list = map.get(digits.charAt(index));

            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                backtracking(digits, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
