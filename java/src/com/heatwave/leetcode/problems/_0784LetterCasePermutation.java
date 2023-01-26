package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class _0784LetterCasePermutation {
    static class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            List<Character> temp = new ArrayList<>();
            backtracking(s.toCharArray(), temp, 0);
            return ans;
        }

        private void backtracking(char[] chars, List<Character> temp, int start) {
            if (temp.size() == chars.length) {
                StringBuilder sb = new StringBuilder();
                for (Character character : temp) {
                    sb.append(character);
                }
                ans.add(sb.toString());
                return;
            }

            for (int i = start; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    temp.add(chars[i]);
                    backtracking(chars, temp, i + 1);
                    temp.remove(temp.size() - 1);
                    continue;
                }
                temp.add(Character.toLowerCase(chars[i]));
                backtracking(chars, temp, i + 1);
                temp.remove(temp.size() - 1);

                temp.add(Character.toUpperCase(chars[i]));
                backtracking(chars, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    static class SolutionBFS {
        public List<String> letterCasePermutation(String s) {
            List<String> list = new ArrayList<>();
            list.add("");

            char[] chars = s.toCharArray();
            for (char c : chars) {
                List<String> another = new ArrayList<>();

                if (Character.isDigit(c)) {
                    for (String str : list) {
                        another.add(str + c);
                    }
                    list = another;
                    continue;
                }

                for (String str : list) {
                    another.add(str + Character.toLowerCase(c));
                    another.add(str + Character.toUpperCase(c));
                }
                list = another;
            }

            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionBFS solutionDFS = new SolutionBFS();
        List<String> list = solutionDFS.letterCasePermutation("a1b2c");
        System.out.println(list);
    }
}
