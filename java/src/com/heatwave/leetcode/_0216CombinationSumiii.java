package com.heatwave.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0216CombinationSumiii {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        int tempSum = 0;
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backtracking(1, 9, k, n);
            return ans;
        }

        private void backtracking(int start, int end, int k, int n) {
            if (temp.size() > k || tempSum > n) {
                return;
            }

            if (temp.size() == k && tempSum == n) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i <= end; i++) {
                temp.add(i);
                tempSum += i;

                backtracking(i + 1, end, k, n);

                temp.remove(temp.size() - 1);
                tempSum -= i;
            }
        }
    }
}
