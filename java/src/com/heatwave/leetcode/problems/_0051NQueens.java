package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class _0051NQueens {
    static class Solution {
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(".");
                }
                temp.add(sb.toString());
            }
            backtracking(n, 0, temp);
            return ans;
        }

        private void backtracking(int n, int row, List<String> temp) {
            if (row > 0) {
                String s = temp.get(row - 1);
                int col = s.indexOf('Q');

                int left = col - 1, right = col + 1;
                for (int i = row - 2; i >= 0; i--, left--, right++) {
                    String rowStr = temp.get(i);
                    if (rowStr.charAt(col) == 'Q') {
                        return;
                    }
                    if (left >= 0 && rowStr.charAt(left) == 'Q') {
                        return;
                    }
                    if (right < n && rowStr.charAt(right) == 'Q') {
                        return;
                    }
                }
            }

            if (row >= n) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < n; i++) {
                String s = temp.get(row);
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, 'Q');
                temp.set(row, sb.toString());

                backtracking(n, row + 1, temp);

                temp.set(row, s);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> ans = solution.solveNQueens(8);
        System.out.println(ans);
    }
}
