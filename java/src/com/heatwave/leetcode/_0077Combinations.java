package com.heatwave.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0077Combinations {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtracking(1, n, k);
            return ans;
        }

        private void backtracking(int start, int end, int k) {
            if (temp.size() + (end - start + 1) < k) {
                return;
            }
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.add(start);
            backtracking(start + 1, end, k);
            temp.remove(temp.size() - 1);
            backtracking(start + 1, end, k);
        }
    }

    static class AnotherSolution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtracking(1, n, k);
            return ans;
        }

        private void backtracking(int start, int end, int k) {
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i <= end; i++) {
                temp.add(i);
                backtracking(i + 1, end, k);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combine(4, 2);

        AnotherSolution anotherSolution = new AnotherSolution();
        anotherSolution.combine(4, 2);
    }
}
