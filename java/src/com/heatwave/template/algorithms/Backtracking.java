package com.heatwave.template.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Backtracking {
    static class Permutations {
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

    static class InPlacePermutations {
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

    static class Combinations {
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

    static class SubSetsSolution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtracking(nums, 0);
            return ans;
        }

        private void backtracking(int[] nums, int start) {
            ans.add(new ArrayList<>(temp));

            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtracking(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
