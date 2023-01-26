package com.heatwave.leetcode.problems;

/**
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * <p>
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * 示例 2：
 * <p>
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-highest-altitude
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1732FindTheHighestAltitude {
    static class Solution {
        public int largestAltitude(int[] gain) {
            int current = 0;
            int max = 0;

            for (int i : gain) {
                current += i;
                if (current > max) {
                    max = current;
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        int res = solution.largestAltitude(gain);
        System.out.println(res);
    }
}
