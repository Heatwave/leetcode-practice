package com.heatwave.leetcode.interviews;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs. The result may be large, so return it modulo 1000000007.
 * <p>
 * Example1:
 * <p>
 * Input: n = 3
 * Output: 4
 * Example2:
 * <p>
 * Input: n = 5
 * Output: 13
 * Note:
 * <p>
 * 1 <= n <= 1000000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interview0801ThreeStepsProblem {
    static class Solution {
        public int waysToStep(int n) {
            long[] dp = new long[n + 1];

            for (int i = 0; i < n + 1; i++) {
                if (i == 0) {
                    dp[i] = 0;
                } else if (i == 1) {
                    dp[i] = 1;
                } else if (i == 2) {
                    dp[i] = 2;
                } else if (i == 3) {
                    dp[i] = 4;
                } else {
                    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
                }
            }

            return (int) dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int step = solution.waysToStep(61);
        System.out.println(step);
    }
}
