package com.heatwave.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *  
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0064MinimumPathSum {
    static class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];

            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int sum = solution.minPathSum(grid);
        System.out.println(sum);
    }
}
