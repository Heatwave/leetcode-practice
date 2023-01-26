package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0039CombinationSum {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, 0, target);
            return ans;
        }

        private void backtracking(int[] nums, int index, int target) {
            int sum = temp.stream().reduce(Integer::sum).orElse(0);
            if (target == sum) {
                ans.add(new ArrayList<>(temp));
            }
            if (sum > target) {
                return;
            }

            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtracking(nums, i, target);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
