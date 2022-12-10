package com.heatwave.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _0046Permutations {
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            backtracking(nums, used);
            return ans;
        }

        private void backtracking(int[] nums, boolean[] used) {
            if (temp.size() == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                temp.add(nums[i]);
                used[i] = true;
                backtracking(nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    static class InPlaceSolution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backtracking(nums, 0);
            return ans;
        }

        private void backtracking(int[] nums, int index) {
            if (index == nums.length) {
                ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }

            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                backtracking(nums, index + 1);
                swap(nums, index, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);

        InPlaceSolution inPlaceSolution = new InPlaceSolution();
        List<List<Integer>> permute1 = inPlaceSolution.permute(nums);
        System.out.println(permute1);
    }
}
