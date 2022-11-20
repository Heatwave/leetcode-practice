package com.heatwave.leetcode;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * <p>
 * Follow up:
 * <p>
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0189RotateArrayInPlace {
    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;

            if (k == 0) {
                return;
            }

            int pos = 0;
            int current = pos, count = 0;
            while (count++ < nums.length) {
                int next = (current + k) % nums.length;
                if (next == pos) {
                    current = ++pos;
                    continue;
                }
                int temp = nums[next];
                nums[next] = nums[pos];
                nums[pos] = temp;
                current = next;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, -100, 3, 99};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
