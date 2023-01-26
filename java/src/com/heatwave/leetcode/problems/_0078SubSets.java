package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class _0078SubSets {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtracking(nums, 0);
            return ans;
        }

        private void backtracking(int[] nums, int index) {
            ans.add(new ArrayList<>(temp));

            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtracking(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    static class AnotherSolution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtracking(nums, 0);
            return ans;
        }

        private void backtracking(int[] nums, int index) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            temp.add(nums[index]);
            backtracking(nums, index + 1);
            temp.remove(temp.size() - 1);
            backtracking(nums, index + 1);
        }
    }
}
