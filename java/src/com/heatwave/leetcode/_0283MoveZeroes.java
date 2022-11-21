package com.heatwave.leetcode;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0283MoveZeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0, right = 0;

            while (left < nums.length) {
                if (nums[left] != 0) {
                    left++;
                    right = left;
                    continue;
                }

                if (nums[left] == 0 && nums[right] != 0) {
                    swap(nums, left, right);
                } else {
                    right++;
                }

                if (right >= nums.length) {
                    left++;
                    right = left;
                }
            }
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    public static void main(String[] args) {

    }
}
