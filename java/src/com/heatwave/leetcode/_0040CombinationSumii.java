package com.heatwave.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040CombinationSumii {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (nums[i] > target) {
                    continue;
                }
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                backtracking(nums, i + 1, target);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
