package com.heatwave.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0491IncreasingSubsequences {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtrack(nums, 0);
            return ans;
        }

        private void backtrack(int[] nums, int index) {
            if (temp.size() > 1) {
                ArrayList<Integer> list = new ArrayList<>(temp);
                if (!set.contains(list)) {
                    ans.add(list);
                    set.add(list);
                }
            }

            for (int i = index; i < nums.length; i++) {
                if (temp.size() > 0 && nums[i] < temp.get(temp.size() - 1)) {
                    continue;
                }
                temp.add(nums[i]);
                backtrack(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    static class AnotherSolution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(0, Integer.MIN_VALUE, nums);
            return ans;
        }

        private void dfs(int cur, int last, int[] nums) {
            if (cur == nums.length) {
                if (temp.size() >= 2) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }

            if (nums[cur] >= last) {
                temp.add(nums[cur]);
                dfs(cur + 1, nums[cur], nums);
                temp.remove(temp.size() - 1);
            }
            if (nums[cur] != last) {
                dfs(cur + 1, last, nums);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findSubsequences(new int[]{1, 2, 3, 1, 1, 1});
    }
}
